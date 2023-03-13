package ru.raspgleb.currenciesoftheworld;

import static android.view.KeyEvent.KEYCODE_ENTER;

import android.os.Bundle;
import android.text.InputFilter;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {
    private String rate = ""; // курс валюты из центробанка за единицу
    private Spinner spinner_currency; // выбор валюты
    private EditText num_of_currency; // ввод количества (если необходимо) для пересчёта
    private TextView text_currency; // итоговый результат цены валюты
    private CurrencyAdapter currencyAdapter; // модификация выбора валюты с отображением флагов
    private Document doc; // документ для информации с парсинга
    private Thread secondThread; // второй поток
    private Runnable runnable; // запуск второго потока

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Инициализация
        text_currency = findViewById(R.id.textView);
        spinner_currency = findViewById(R.id.spinner_currency);
        // Получение информации из класса Data о валютах
        currencyAdapter = new CurrencyAdapter(MainActivity.this, Data.getCurrencyList());
        // Установка модификации с флагами и соответствующими названиями валют
        spinner_currency.setAdapter(currencyAdapter);
        // Инициализация и установка лимита по длинне ввода юзера
        num_of_currency = findViewById(R.id.editTextNumberCurrency);
        int maxLength = 10;
        num_of_currency.setFilters(new InputFilter[] {new InputFilter.LengthFilter(maxLength)});
        // Обработка нажатия на Enter
        num_of_currency.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                boolean consumed = false;
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KEYCODE_ENTER)) {
                    if (num_of_currency.getText().length() != 0) { // Проверка наличия
                        String num = num_of_currency.getText().toString().replaceAll("\\s+", "");
                        if (num.length() != 0) {
                            double user_input = Double.parseDouble(num); // Пользовательское значение количества
                            num_of_currency.setHint(String.format(Locale.US,"%.3f",user_input)); // Установка в подсказку для запоминания
                            try{ // Если число десятичного вида, то ликвидируем лишние нули
                                if (num_of_currency.getHint().toString().split("\\.")[1].equals("000")) {
                                    num_of_currency.setHint(String.format(Locale.US,"%.0f",user_input));;
                                }
                            }catch (Exception e){
                                System.out.println(e);
                            }

                            // Курс валюты
                            double rate = Double.parseDouble(MainActivity.this.rate.split(" ")[0].replaceAll(",", "."));
                            // Пересчёт значения в зависимости от числа со стороны пользователя
                            text_currency.setText(String.format(Locale.US, "%s ₽", multiply(user_input, rate).replaceAll("\\.",",")));
                            user_input = 0.0;
                            rate = 0.0;
                        }

                    }
                    consumed = true;
                }
                return consumed;
            }
        });
        // Выбор валюты
        spinner_currency.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    // Поле для ввода открыто
                    num_of_currency.setLongClickable(true);
                    num_of_currency.setCursorVisible(true);
                    num_of_currency.setFocusableInTouchMode(true);
                    num_of_currency.setFocusable(true);
                    num_of_currency.getText().clear(); // Сброс старого значения от пользователя
                    init(position);
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Выберите валюту", Toast.LENGTH_SHORT);
                    toast.show();
                    // Поле для ввода закрыто
                    text_currency.setText("");
                    num_of_currency.getText().clear();
                    num_of_currency.setHint("0");
                    num_of_currency.setLongClickable(false);
                    num_of_currency.setCursorVisible(false);
                    num_of_currency.setFocusableInTouchMode(false);
                    num_of_currency.setFocusable(false);
                }
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
    // Запуск
    private void init(int selected_position) {
        runnable = new Runnable() {
            @Override
            public void run() {
                getInfo(selected_position);
            }
        };
        secondThread = new Thread(runnable);
        secondThread.start();
    }
    // Парсинг данных о валютах с сайта ЦБ РФ
    private void getInfo(int position) {
        try {
            doc = Jsoup.connect("https://cbr.ru/currency_base/daily/").get();
            Element table_currency = doc.getElementsByTag("tbody").get(0);
            Elements elements_table = table_currency.children();
            String[] info_array = elements_table.get(position).children().text().split(" ");
            num_of_currency.setHint(String.format("%s", info_array[2]));
            rate = String.format(Locale.US,"%.3f",Double.parseDouble(info_array[info_array.length - 1].replaceAll(",", "."))/Double.parseDouble(info_array[2]));
            text_currency.setText(String.format("%s ₽", info_array[info_array.length - 1]));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Пересчёт значения курса в зависимости от числа со стороны пользователя
    private String multiply(double a, double b) {
        String formattedDouble = String.format(Locale.US, "%.3f", a * b);
        if (formattedDouble.split("\\.")[1].equals("000")) {
            formattedDouble = formattedDouble.split("\\.")[0];
        }
        return formattedDouble;
    }
}


