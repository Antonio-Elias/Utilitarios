/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitario.teste;

import java.util.Scanner;
import utilitario.ValidaDados;

/**
 *
 * @author Antonio
 */
public class TestandoValidacoes {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o seu documento: ");
        String documento = scan.nextLine();
        
        if(documento.length() == 11){
            System.out.println(ValidaDados.isCpf(documento)?"CPF Valido":"CPF Invalido");
        }else{     
            System.out.println(ValidaDados.isCnpj(documento)?"CNPJ Valido":"CNPJ Invalido");        
        }
        
    }
    
}
