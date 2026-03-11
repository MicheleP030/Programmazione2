/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blocchi;

/**
 *
 * @author michele.piamarta
 */
//esempio singelton, 1 istanza per tutto il programma
public class UovoDrago {
    
    private static UovoDrago uovo = null;
    
    private UovoDrago() {} 
    
    public UovoDrago getUovo(){
        if(uovo == null){
            uovo = new UovoDrago();
        }
        return uovo;
    }
}
