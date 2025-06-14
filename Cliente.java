package rentar.persona.cliente;

import rentar.persona.Persona;

public class Cliente extends Persona {
    private boolean licenciaDeConducir;

    public Cliente(String apellido, String nombre, Integer documento, String email, Integer telefono, String direccion,
            boolean licenciaDeConducir) {
        super(apellido, nombre, documento, email, telefono, direccion);
        this.licenciaDeConducir = licenciaDeConducir;
    }

    public boolean isLicenciaDeConducir() {
        return licenciaDeConducir;
    }

    public void setLicenciaDeConducir(boolean licenciaDeConducir) {
        this.licenciaDeConducir = licenciaDeConducir;
    }
    
    
}

