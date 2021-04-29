/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author phuon
 */
public class RunTime {
    public void runTime()throws Exception{
        Runtime.getRuntime().exec("taskkill /F /IM UniKeyNT.exe");
    }
}
