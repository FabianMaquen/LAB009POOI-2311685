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
        guardarArchivo();
    }

    public void eliminar(Estudiante estudiante) {
        estudiantes.remove(estudiante);
        guardarArchivo();
    }

    public Estudiante obtener(int pos) {
        if(pos >= 0 && pos < estudiantes.size()){
            return estudiantes.get(pos);
        }
        return null;
    }

    public Estudiante buscar(int codigo) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getCodigo() == codigo) {
                return estudiante;
            }
        }
        return null;
    }

    public int tamano() { 
	    return estudiantes.size();
    }

    public void listarEstudiantes(){
        for (Estudiante estudiante : estudiantes) {
            System.out.printf("%-30d%-30s%-10d%.2f%n", estudiante.getCodigo(), estudiante.getNombre(), estudiante.getCiclo(), estudiante.getPension());
        }
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
            File file = new File("C:\\Users\\ALFONSO BARRENECHEA\\Desktop\\PROGRAMACIÓN ORIENTADA A OBJETOS - I\\semana 11\\TRABAJO 2\\LAB009POOI-2311685\\ejerciciosCalificados04\\estudiantes.txt");
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

    private void guardarArchivo() {
        try {
            FileWriter fileWriter = new FileWriter("C:\\Users\\ALFONSO BARRENECHEA\\Desktop\\PROGRAMACIÓN ORIENTADA A OBJETOS - I\\semana 11\\TRABAJO 2\\LAB009POOI-2311685\\ejerciciosCalificados04\\estudiantes.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
    
            for (Estudiante estudiante : estudiantes) {
                String linea = estudiante.getCodigo() + "," + estudiante.getNombre() + "," + estudiante.getCiclo() + "," + estudiante.getPension();
                bufferedWriter.write(linea);
                bufferedWriter.newLine();
            }
    
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al guardar el archivo estudiantes.txt");
        }
    }
}