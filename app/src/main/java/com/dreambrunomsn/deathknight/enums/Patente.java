package com.dreambrunomsn.deathknight.enums;

public enum Patente {
    RESERVA(1, "Reserva"),
    RECRUTA(10, "Recruta"),
    SOLDADO(20, "Soldado"),
    CABO(30, "Cabo"),
    SARGENTO3(40, "3º Sargento"),
    SARGENTO2(50, "2º Sargento"),
    SARGENTO1(60, "1º Sargento"),
    SUBTENENTE(70, "Subtenente"),
    TENENTE(80, "Tenente"),
    CAPITAO(90, "Capitão"),
    MAJOR(100, "Major"),
    TEN_COR(110, "Tenente Coronel"),
    CORONEL(120, "Coronel"),
    GEN_BRIG(130, "General de Brigada"),
    GEN_DIV(140, "General de Divisão"),
    GEN_EXE(150, "General de Exército"),
    MARECHAL(160, "Marechal");

    private int codigo;
    private String patente;

    Patente(int cod, String patente) {
        this.codigo = cod;
        this.patente = patente;
    }

    public int getCodigo(){
        return codigo;
    }
    public String getPatente(){
        return patente;
    }


    public static Patente getEnum(int cod){
        for(Patente item : Patente.values()){
            if(item.getCodigo() == cod){
                return item;
            }
        }
        return null;
    }

    public static String getPatente(int cod){
        return getEnum(cod).getPatente();
    }
}
