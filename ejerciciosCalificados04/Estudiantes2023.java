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

    public Estudiante buscarNombre(String apellidoBuscado) {
        boolean encontrado = false;

        for (Estudiante estudiante : estudiantes) {
            String[] nombreYApellido = estudiante.getNombre().split(" ");
            String apellido = nombreYApellido[nombreYApellido.length - 1];

            if (apellido.equals(apellidoBuscado)) {
                System.out.println(estudiante.getNombre());
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("El alumno no está registrado.");
        }

        return null;
    }
    
    public void modificarApellidos() {
        for (Estudiante estudiante : estudiantes) {
            String nombreCompleto = estudiante.getNombre();
            String[] dividirNombre = nombreCompleto.split(" ");
        
            if (dividirNombre.length >= 2) {
                String nombre = dividirNombre[0];
                String apellido = dividirNombre[1];
                
                char primeraLetraApellido = Character.toUpperCase(apellido.charAt(0));
                apellido = primeraLetraApellido + apellido.substring(1);
        
                estudiante.setNombre(nombre + " " + apellido);
            }
        }
    }

    public void listarPensionEstudiante() {
        Collections.sort(estudiantes, new Comparator<Estudiante>() {
            @Override
            public int compare(Estudiante estudiante1, Estudiante estudiante2) {
                return Double.compare(estudiante1.getPension(), estudiante2.getPension());
            }
        });

        System.out.println("-----------------------------------------------------------------------------------");
        System.out.printf("%-30s%-30s%-10s%s%n", "CODIGO DE ESTUDIANTE", "NOMBRE Y APELLIDO", "CICLO", "PENSION");
        System.out.println("-----------------------------------------------------------------------------------");
        
        for (Estudiante estudiante : estudiantes) {
            System.out.printf("%-30d%-30s%-10d%.2f%n", estudiante.getCodigo(), estudiante.getNombre(), estudiante.getCiclo(), estudiante.getPension());
        }

        System.out.println("-----------------------------------------------------------------------------------");
    }

    public void listarNombresEstudiantes() {
        System.out.println("****** LISTA DE NOMBRES DE ESTUDIANTES ********");
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.printf("%-30s%-30s%-10s%s%n", "CODIGO DE ESTUDIANTE", "NOMBRE Y APELLIDO", "CICLO", "PENSION");
        System.out.println("-----------------------------------------------------------------------------------");
    
        for (Estudiante estudiante : estudiantes) {
            String[] nombreYApellido = estudiante.getNombre().split(" ");
            String nombre = nombreYApellido[0];
            System.out.printf("%-30d%-30s%-10d%.2f%n", estudiante.getCodigo(), nombre, estudiante.getCiclo(), estudiante.getPension());
            
        }
    
        System.out.println("-----------------------------------------------------------------------------------");
    }

    public void listarApellidosEstudiantes() {
        System.out.println("****** LISTA DE ESTUDIANTES ********");
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.printf("%-30s%-30s%-10s%s%n", "CODIGO DE ESTUDIANTE", "NOMBRE Y APELLIDO", "CICLO", "PENSION");
        System.out.println("-----------------------------------------------------------------------------------");

        for (Estudiante estudiante : estudiantes) {
            String[] nombreYApellido = estudiante.getNombre().split(" ");
            String apellido = nombreYApellido[nombreYApellido.length - 1];
            System.out.printf("%-30d%-30s%-10d%.2f%n", estudiante.getCodigo(), apellido, estudiante.getCiclo(), estudiante.getPension());
        }

        System.out.println("-----------------------------------------------------------------------------------");
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
            File file = new File("C:\\Users\\Fabian Maquen\\Desktop\\CICLO 02\\POO\\Actividades\\S11\\LAB009POOI-2311685\\ejerciciosCalificados04\\estudiantes.txt");
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
            FileWriter fileWriter = new FileWriter("C:\\Users\\Fabian Maquen\\Desktop\\CICLO 02\\POO\\Actividades\\S11\\LAB009POOI-2311685\\ejerciciosCalificados04\\estudiantes.txt");
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