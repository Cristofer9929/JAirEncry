/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encriptadocesar;

/**
 *
 * @author cris-
 */
import java.io.IOException;
import java.util.Scanner;

public class CifradoCesar {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String texto, codigo, r;
        char opcion;
        CifradoCesar v = new CifradoCesar();

            //Introducir un texto
            do {
                System.out.print("Introduce un texto: ");
                texto = sc.nextLine();
            } while (texto.isEmpty());

            //Introducir el valor del desplazamiento
            do {
                System.out.print("Introduce el código: ");
                codigo = sc.nextLine();
            } while (codigo.isEmpty());  



            //Valida y realiza acción
            if(v.validarCodigo(codigo) && v.validaTexto(texto)){
                System.out.println("Texto cifrado: " + cifradoCesar(texto, codigo));
            }
            else{
                System.out.println("Los valores no son correctos intentelo de nuevo.");
            }
    }
    
    
    //Validar la cadena
    public boolean validaTexto(String t){
        int valorASCII=0;
        for(int i=0 ; i<t.length() ; i++){
            char c=t.charAt(i);
            valorASCII=(int) c;
            if(valorASCII<97 || valorASCII > 122){
                return false;
            }
        }
        return true;
    }
    
    
    //Validar numero
    public boolean validarCodigo(String c) {
                int c2;
		try
                {
                    c2=Integer.parseInt(c);
                    return true;
                }catch(Exception e){
                    return false;
                }
	}
    
    
    //método para cifrar el texto
    public static String cifradoCesar(String texto, String c) {
        StringBuilder cifrado = new StringBuilder();
        int codigo=Integer.parseInt(c);
        codigo = codigo % 26;
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') {
                if ((texto.charAt(i) + codigo) > 'z') {
                    cifrado.append((char) (texto.charAt(i) + codigo - 26));
                } else {
                    cifrado.append((char) (texto.charAt(i) + codigo));
                }
            } else if (texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z') {
                if ((texto.charAt(i) + codigo) > 'Z') {
                    cifrado.append((char) (texto.charAt(i) + codigo - 26));
                } else {
                    cifrado.append((char) (texto.charAt(i) + codigo));
                }
            }
        }
        return cifrado.toString();
    }
}