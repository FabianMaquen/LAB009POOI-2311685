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
        for (Estudiante estudiante : estudiantes) {
            return estudiantes.get(pos);
        }        
        return null;
    }

    public Estudiante buscar(int codigo) {
        for (Estudiante estudiante : estudiantes) {
            if(estudiante.getCodigo() == codigo){
                return estudiante;
            }
        }
        return null;
    }

    public int tamano() {
        estudiantes.size();        
	    return 0;
    }

    public void listarEstudiantes(){
        //Introduce c digo        
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
            File file = new File("C:\\TRABAJO GRUPAL\\TRABAJO GRUPAL2\\LAB009POOI-2311685\\ejerciciosCalificados04\\estudiantes.txt");
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