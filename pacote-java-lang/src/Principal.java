import java.lang.*;
//Não há a necessidade de fazer o import acima, ele já é feito automaticamente
//pois o pacote java.lang tem as principais e essênciais classes do Java
//String e Exceções estão todas dentro do Java.Lang
public class Principal {
    public static void main(String[] args) {
        //String e imutabilidade
        String nome = "Alura";

        //Existem vários métodos que a String nos disponibilizam!
        String nvNome = nome.replace("A", "a");

        System.out.println(nvNome);//Devemos criar uma nova String para que os métodos funcionem
        System.out.println(nome); //Permanece imutável

        String maius = nome.toUpperCase();
        System.out.println(maius);

        //Principais métodos
        char c = nome.charAt(3);// -> retorna o caractere da posição 'x'
        System.out.println(c);

        int ind = nome.indexOf("r");// -> retorna a posição do primeiro caractere da substring
        System.out.println(ind);

        String sub = nome.substring(3);// -> retorna a subtring a partir da posição de um caractere, podemos indicar o fim também
        System.out.println(sub);

        int tam = nome.length();// -> retorna o tamanho da String, igual umas lista
        System.out.println(tam);

        for (int i = 0; i < nome.length(); i++) {
            System.out.println(nome.toUpperCase().charAt(i));
        }

        boolean vazio = nome.isEmpty();// -> retorna uma resposta lógica dependendo se a String estiver vazia ou não
        boolean empty = nome.trim().isEmpty();//trim retira todos os espaços do inicio e do fim de uma String
        System.out.println(vazio);

        boolean tem = nome.contains("ura");// -> retorna uma resposta lógica se a String conter os caracteres passados no parâmetro
        System.out.println(tem);
    }
}
