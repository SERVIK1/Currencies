package ru.raspgleb.currenciesoftheworld;

import java.util.ArrayList;
import java.util.List;

public class Data {

    public static List<Currency> getCurrencyList(){
        // Список валют
        List<Currency> currencyList = new ArrayList<>();

        // default поле
        Currency default_currency = new Currency();
        default_currency.setName("Выберите валюту");
        currencyList.add(default_currency);

        // Объект-валюта
        Currency AUD = new Currency();
        AUD.setName("AUD | Австралийский доллар");
        AUD.setImage(R.drawable._______3svg);
        currencyList.add(AUD);

        Currency AZN = new Currency();
        AZN.setName("AZN | Азербайджанский манат");
        AZN.setImage(R.drawable._______7svg);
        currencyList.add(AZN);

        Currency AMD = new Currency();
        AMD.setName("AMD | Армянских драмов"); //100
        AMD.setImage(R.drawable._______8svg);
        currencyList.add(AMD);

        Currency BYN = new Currency();
        BYN.setName("BYN | Белорусский рубль");
        BYN.setImage(R.drawable._______9svg);
        currencyList.add(BYN);

        Currency BGN = new Currency();
        BGN.setName("BGN | Болгарский лев");
        BGN.setImage(R.drawable._______10svg);
        currencyList.add(BGN);

        Currency BRL = new Currency();
        BRL.setName("BRL | Бразильский реал");
        BRL.setImage(R.drawable._______11svg);
        currencyList.add(BRL);

        Currency HUF = new Currency();
        HUF.setName("HUF | Венгерских форинтов"); //100
        HUF.setImage(R.drawable._______12svg);
        currencyList.add(HUF);

        Currency KRW = new Currency();
        KRW.setName("KRW | Вон Республики Корея"); //1000
        KRW.setImage(R.drawable._______13svg);
        currencyList.add(KRW);

        Currency VND = new Currency();
        VND.setName("VND | Вьетнамских донгов"); //10 000
        VND.setImage(R.drawable._______14svg);
        currencyList.add(VND);

        Currency HKD = new Currency();
        HKD.setName("HKD | Гонконгских долларов"); //10
        HKD.setImage(R.drawable._______15svg);
        currencyList.add(HKD);

        Currency GEL = new Currency();
        GEL.setName("GEL | Грузинский лари");
        GEL.setImage(R.drawable._______16svg);
        currencyList.add(GEL);

        Currency DKK = new Currency();
        DKK.setName("DKK | Датская крона");
        DKK.setImage(R.drawable._______17svg);
        currencyList.add(DKK);

        Currency AED = new Currency();
        AED.setName("AED | Дирхам ОАЭ");
        AED.setImage(R.drawable._______18svg);
        currencyList.add(AED);

        Currency USD = new Currency();
        USD.setName("USD | Доллар США");
        USD.setImage(R.drawable._______19svg);
        currencyList.add(USD);

        Currency EUR = new Currency();
        EUR.setName("EUR | Евро");
        EUR.setImage(R.drawable._______20svg);
        currencyList.add(EUR);

        Currency EGP = new Currency();
        EGP.setName("EGP | Египетских фунтов");//10
        EGP.setImage(R.drawable._______21svg);
        currencyList.add(EGP);

        Currency INR = new Currency();
        INR.setName("INR | Индийских рупий");//100
        INR.setImage(R.drawable._______22svg);
        currencyList.add(INR);

        Currency IDR = new Currency();
        IDR.setName("IDR | Индонезийских рупий");//10 000
        IDR.setImage(R.drawable._______23svg);
        currencyList.add(IDR);

        Currency KZT = new Currency();
        KZT.setName("KZT | Казахстанских тенге");//100
        KZT.setImage(R.drawable._______24svg);
        currencyList.add(KZT);

        Currency CAD = new Currency();
        CAD.setName("CAD | Канадский доллар");
        CAD.setImage(R.drawable._______25svg);
        currencyList.add(CAD);

        Currency QAR = new Currency();
        QAR.setName("QAR | Катарский риал");
        QAR.setImage(R.drawable._______26svg);
        currencyList.add(QAR);

        Currency KGS = new Currency();
        KGS.setName("KGS | Киргизских сомов");//100
        KGS.setImage(R.drawable._______27svg);
        currencyList.add(KGS);

        Currency CNY = new Currency();
        CNY.setName("CNY | Китайский юань");
        CNY.setImage(R.drawable._______28svg);
        currencyList.add(CNY);

        Currency MDL = new Currency();
        MDL.setName("MDL | Молдавских леев"); //10
        MDL.setImage(R.drawable._______29svg);
        currencyList.add(MDL);

        Currency NZD = new Currency();
        NZD.setName("NZD | Новозеландский доллар");
        NZD.setImage(R.drawable._______30svg);
        currencyList.add(NZD);

        Currency TMT = new Currency();
        TMT.setName("TMT | Новый туркменский манат");
        TMT.setImage(R.drawable._______31svg);
        currencyList.add(TMT);

        Currency NOK = new Currency();
        NOK.setName("NOK | Норвежских крон");//10
        NOK.setImage(R.drawable._______32svg);
        currencyList.add(NOK);

        Currency PLN = new Currency();
        PLN.setName("PLN | Польский злотый");
        PLN.setImage(R.drawable._______33svg);
        currencyList.add(PLN);

        Currency RON = new Currency();
        RON.setName("RON | Румынский лей");
        RON.setImage(R.drawable._______34svg);
        currencyList.add(RON);

        Currency XDR = new Currency();
        XDR.setName("СДР | Cпециальные права заимствования");
        currencyList.add(XDR);

        Currency RSD = new Currency();
        RSD.setName("RSD | Сербских динаров");//100
        RSD.setImage(R.drawable._______35svg);
        currencyList.add(RSD);

        Currency SGD = new Currency();
        SGD.setName("SGD | Сингапурский доллар");
        SGD.setImage(R.drawable._______36svg);
        currencyList.add(SGD);

        Currency TJS = new Currency();
        TJS.setName("TJS | Таджикских сомони");//10
        TJS.setImage(R.drawable._______37svg);
        currencyList.add(TJS);

        Currency THB = new Currency();
        THB.setName("THB | Таиландских батов");//10
        THB.setImage(R.drawable._______38svg);
        currencyList.add(THB);

        Currency TRY = new Currency();
        TRY.setName("TRY | Турецких лир");//10
        TRY.setImage(R.drawable._______39svg);
        currencyList.add(TRY);

        Currency UZS = new Currency();
        UZS.setName("UZS | Узбекских сумов");//10 000
        UZS.setImage(R.drawable._______40svg);
        currencyList.add(UZS);

        Currency UAH = new Currency();
        UAH.setName("UAH | Украинских гривен");//10
        UAH.setImage(R.drawable._______41svg);
        currencyList.add(UAH);

        Currency GBP = new Currency();
        GBP.setName("GBP | Фунт стерлингов");
        GBP.setImage(R.drawable._______42svg);
        currencyList.add(GBP);

        Currency CZK = new Currency();
        CZK.setName("CZK | Чешских крон");//10
        CZK.setImage(R.drawable._______43svg);
        currencyList.add(CZK);

        Currency SEK = new Currency();
        SEK.setName("SEK | Шведских крон");//10
        SEK.setImage(R.drawable._______44svg);
        currencyList.add(SEK);

        Currency CHF = new Currency();
        CHF.setName("CHF | Швейцарский франк");
        CHF.setImage(R.drawable._______45svg);
        currencyList.add(CHF);

        Currency ZAR = new Currency();
        ZAR.setName("ZAR | Южноафриканских рэндов");//10
        ZAR.setImage(R.drawable._______46svg);
        currencyList.add(ZAR);

        Currency JPY = new Currency();
        JPY.setName("JPY | Японских иен");//100
        JPY.setImage(R.drawable._______47svg);
        currencyList.add(JPY);

        return currencyList;
    }
}
