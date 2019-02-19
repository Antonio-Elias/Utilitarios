/*
 *Esta classe serve para validação de entrada de dados, os metodos validarão as entradas e
 * retornaram um true para valido  e false para invalido
 */
package utilitario;

import java.util.InputMismatchException;

/**
 *
 * @author Antonio
 * @version 1.0
 */
public class ValidaDados {
    // esta classe não  necessita de um construtor com parametros.
    

    public static boolean isCpf(String cpf){
        // este metodo trabalha apenas com os numeros em formato de strings sem carateteres especiais
        // melhoria a ser aplicada: substituir as conversoes de String para inteiro, por char, e usar o metodo charAt
        // para estrair os inteiros.
        
        if((cpf.length() != 11) || ("00000000000".equals(cpf))||("11111111111".equals(cpf))||
           ("22222222222".equals(cpf)) || ("33333333333".equals(cpf)) || ("44444444444".equals(cpf))||
           ("55555555555".equals(cpf)) || ("66666666666".equals(cpf)) || ("77777777777".equals(cpf))||
           ("88888888888".equals(cpf)) || ("99999999999".equals(cpf))){
           return false;
        }
        String nove = cpf.substring(0, 9);
        int soma = 0;
        // verificaçao do primeiro digito
        for (int i = 1; i <= 9; i++) {
            try{
                soma += Integer.parseInt(nove.substring(i-1, i)) * (11 - i);
            }catch(NumberFormatException ex){
                return false;
            }    
        }
        // primeiro digito 
        int dig1 = 11 - (soma % 11);
        
        // se o primeiro digito for menor que 9 ele fica 0;
        if (dig1 > 9 ){
            dig1 = 0;
        }
        
        // verifica o segundo digito
        soma = 0;
        nove = cpf.substring(0, 10);
        for (int i = 1; i <= 10; i++) {
            try{
                soma += Integer.parseInt(nove.substring(i-1, i)) * (12 - i);
            }catch(NumberFormatException ex){
                return false;
            }    
        }
        // primeiro digito 
        int dig2 = 11 - (soma % 11);
        
        // se o segundo digito for menor que 9 ele fica 0;
        if (dig2 > 9 ){
            dig2 = 0;
        }
        
        // validacao
        try{
            return dig1 == Integer.parseInt(cpf.substring(9, 10)) && (dig2 == Integer.parseInt(cpf.substring(cpf.length() -1)));
        }catch(NumberFormatException ex){
            return false;
        }
    }
    
    public static boolean isCnpj(String cnpj){
        // este metodo trabalha com char e usa o metodo charAt para estrair os numeros inteiros
       
        if((cnpj.length() != 14) || ("00000000000000".equals(cnpj))||("11111111111111".equals(cnpj))||
           ("22222222222222".equals(cnpj)) || ("33333333333333".equals(cnpj)) || ("44444444444444".equals(cnpj))||
           ("55555555555555".equals(cnpj)) || ("66666666666666".equals(cnpj)) || ("77777777777777".equals(cnpj))||
           ("88888888888888".equals(cnpj)) || ("99999999999888".equals(cnpj))){
           return false;
        }
       
        char dig13, dig14;
        int soma, resto, num, peso;
        
        try{
            soma = 0;
            peso = 2;
            
            for(int i = 11; i>=0; i--){
                num = (int)(cnpj.charAt(i)-48);
                soma += (num * peso);
                peso++;
                if(peso == 10){
                    peso =2;
                }
            }
            resto = (soma%11);
            if((resto == 0)||(resto == 1)){
                dig13 ='0';
            }else{
                dig13 = (char)((11-resto) + 48);
            }
            
            
            soma = 0;
            peso = 2;
            
            for(int i = 12; i>=0; i--){
                num = (int)(cnpj.charAt(i)-48);
                soma += (num * peso);
                peso++;
                if(peso == 10){
                    peso = 2;
                }
            }
            resto = soma % 11;
            if((resto == 0)||(resto ==0)){
                dig14 = '0';
            }else{
                dig14 = (char)((11 - resto)+48);
            }
            
            return (dig13 == cnpj.charAt(12))&&(dig14 == cnpj.charAt(13));
          
        }catch(InputMismatchException ex){
                return false;
        }
    }
    
}
        
        
        
