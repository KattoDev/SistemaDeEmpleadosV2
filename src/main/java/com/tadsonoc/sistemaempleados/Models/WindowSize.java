package com.tadsonoc.sistemaempleados.Models;

public class WindowSize {
    private static final int[] login = {640, 480};
    private static final int[] dashboard = {1280, 800};

    public static int[] getLogin() {
        return login;
    }

    public static  int[] getDashboard() {
        return dashboard;
    }
}
