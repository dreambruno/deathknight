package com.dreambrunomsn.deathknight.utilitario;

import java.util.Calendar;

/**
 * Created by Dream on 29/04/2018.
 */

public class Data {

    /**
     * Recebe data no formato numérico yyyyMMdd(ex: 19810715)
     * @param i - número que representa a data
     * @return A data no formato Calendar
     */
    public static Calendar setData(int i){
        String data = Integer.toString(i);
        Calendar cal = Calendar.getInstance();

        if (data.length() >= 8){
            try{
                cal.set(Calendar.YEAR, Integer.parseInt(data.substring(0,4)));
                cal.set(Calendar.MONTH, Integer.parseInt(data.substring(4,6)));
                cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(data.substring(6,8)));
                if(data.length() == 12){
                    cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(data.substring(8,10)));
                    cal.set(Calendar.MINUTE, Integer.parseInt(data.substring(10,12)));
                } else{
                    cal.set(Calendar.HOUR_OF_DAY, 0);
                    cal.set(Calendar.MINUTE, 0);
                }
                cal.set(Calendar.SECOND, 0);
            } catch (Exception e){
                // TODO: erro na formação da data!!!
            }
        } else{
            // TODO: erro no comprimento da data base!!!
        }

        return cal;
    }

    /**
     * Retorna um número como string tendo duas casas decimais.
     * @param num
     * @return string de dois dígitos.
     */
    public static String addZero(int num){
        if(num < 10){
            return "0" + num;
        } else{
            return Integer.toString(num);
        }
    }
    /**
    * Retorna a data no formato dd/mm/aaaa
     * @param data no formato Calendar
     * @return string
     **/
    public static String dataFormatada(Calendar data){
        String retorno = "";
        if(data != null) {
            retorno = addZero(data.get(Calendar.DAY_OF_MONTH)) + "/";
            retorno += addZero(data.get(Calendar.MONTH) + 1) + "/";
            retorno += data.get(Calendar.YEAR);
        }
        return retorno;
    }

    public static int calendarToInt(Calendar diaTeste) {
        String data =   diaTeste.get(Calendar.YEAR)
                        + Data.addZero(diaTeste.get(Calendar.MONTH))
                        + Data.addZero(diaTeste.get(Calendar.DAY_OF_MONTH));

        return Integer.valueOf(data);
    }
}
