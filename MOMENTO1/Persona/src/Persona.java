import java.util.Random;

class Persona {
    // Constantes
    private static final char SEXO_POR_DEFECTO = 'H';
    private static final int PESO_BAJO = -1;
    private static final int PESO_IDEAL = 0;
    private static final int SOBREPESO = 1;

    private String nombre;
    private int edad;
    private String DNI;
    private char sexo;
    private double peso;
    private double altura;

    public Persona() {
        this.nombre = "";
        this.edad = 0;
        this.sexo = SEXO_POR_DEFECTO;
        this.peso = 0.0;
        this.altura = 0.0;
        this.DNI = generaDNI();
    }

    public Persona(String nombre, int edad, char sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = comprobarSexo(sexo);
        this.peso = 0.0;
        this.altura = 0.0;
        this.DNI = generaDNI();
    }

    public Persona(String nombre, int edad, char sexo, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = comprobarSexo(sexo);
        this.peso = peso;
        this.altura = altura;
        this.DNI = generaDNI();
    }

    public int calcularIMC() {
        if (altura == 0) {
            return PESO_BAJO;
        }

        double imc = peso / Math.pow(altura, 2);

        if (imc < 20) {
            return PESO_BAJO;
        } else if (imc >= 20 && imc <= 25) {
            return PESO_IDEAL;
        } else {
            return SOBREPESO;
        }
    }

    public boolean esMayorDeEdad() {
        return edad >= 18;
    }

    private char comprobarSexo(char sexo) {
        if (sexo == 'H' || sexo == 'M') {
            return sexo;
        } else {
            return SEXO_POR_DEFECTO;
        }
    }

    @Override
    public String toString() {
        return "Información de la Persona:\n" +
                "Nombre: " + nombre + "\n" +
                "Edad: " + edad + " años\n" +
                "DNI: " + DNI + "\n" +
                "Sexo: " + sexo + "\n" +
                "Peso: " + peso + " kg\n" +
                "Altura: " + altura + " m";
    }

    private String generaDNI() {
        Random random = new Random();
        int numeroDNI = random.nextInt(90000000) + 10000000; // Genera número de 8 cifras
        char letraDNI = calcularLetraDNI(numeroDNI);
        return numeroDNI + "" + letraDNI;
    }

    private char calcularLetraDNI(int numeroDNI) {
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        int indice = numeroDNI % 23;
        return letras.charAt(indice);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setSexo(char sexo) {
        this.sexo = comprobarSexo(sexo);
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
}