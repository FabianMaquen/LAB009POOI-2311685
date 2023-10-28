package ejerciciosCalificados04;

import java.util.*;
import javax.swing.*;
import java.io.*;

public class Estudiantes2023 {
    private static ArrayList<Estudiante> estudiantes;

    public Estudiantes2023() {
        estudiantes = new ArrayList<>();
        cargarArchivo();
    }

    public void adicionar(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    public void eliminar(Estudiante estudiante) {
        estudiantes.remove(estudiante);
    }

    public Estudiante obtener(int pos) {
<<<<<<< HEAD
        for (Estudiante estudiante : estudiantes) {
            return estudiantes.get(pos);
        }        
=======
        estudiantes.get(pos);
>>>>>>> 9835f4309d46f5c65d8bab36a46cc05f40e98165
        return null;
    }

    public Estudiante buscar(int codigo) {
        for (Estudiante estudiante : estudiantes) {
<<<<<<< HEAD
            if(estudiante.getCodigo() == codigo){
=======
            if (estudiante.getCodigo() == codigo) {
>>>>>>> 9835f4309d46f5c65d8bab36a46cc05f40e98165
                return estudiante;
            }
        }
        return null;
    }

    public int tamano() {
<<<<<<< HEAD
        estudiantes.size();        
=======
        //Introduce codigog   
>>>>>>> 9835f4309d46f5c65d8bab36a46cc05f40e98165
	    return 0;
    }

    public void listarEstudiantes(){
<<<<<<< HEAD
        //Introduce c digo        
=======
        //Introduce codigo        
>>>>>>> 9835f4309d46f5c65d8bab36a46cc05f40e98165
    }

    // M todos para manipular el archivo de texto
    private void readFromInputStream(InputStream inputStream) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String linea;
        while ((linea = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(linea, ",");
            createStudent(st);
        }
        br.close();
    }

	// M todo que a adir a los estudiantes del archivo .txt en el arrayList estudiantes.
    private void createStudent(StringTokenizer st){
        int codigo = Integer.parseInt(st.nextToken().trim());
        String nombre = st.nextToken().trim();
        int ciclo = Integer.parseInt(st.nextToken().trim());
        double pension = Double.parseDouble(st.nextToken().trim());
        Estudiante estudiante = new Estudiante(codigo, nombre, ciclo, pension);
        adicionar(estudiante);
    }

    // M todos para manipular el archivo de texto
    private void cargarArchivo() {
        try {
<<<<<<< HEAD
            File file = new File("C:\\TRABAJO GRUPAL\\TRABAJO GRUPAL2\\LAB009POOI-2311685\\ejerciciosCalificados04\\estudiantes.txt");
=======
            File file = new File("C:\\Users\\Fabian Maquen\\Desktop\\CICLO 02\\POO\\Actividades\\S11\\LAB009POOI-2311685\\ejerciciosCalificados04\\estudiantes.txt");
>>>>>>> 9835f4309d46f5c65d8bab36a46cc05f40e98165
            Class<Estudiantes2023> clazz = Estudiantes2023.class;
            InputStream inputStream = clazz.getResourceAsStream("estudiantes.txt");
            if (file.exists()) {
                readFromInputStream(inputStream);
            } else
                JOptionPane.showMessageDialog(null,
                        "El archivo estudiantes.txt no existe");
        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "Se produjo un error= " + x);
        }
    }
}
