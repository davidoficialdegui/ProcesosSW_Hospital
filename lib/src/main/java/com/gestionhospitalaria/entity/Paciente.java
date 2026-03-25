package com.gestionhospitalaria.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20, unique = true)
    private String dni;

    @Column(name = "numero_historia_clinica", nullable = false, unique = true, length = 30)
    private String numeroHistoriaClinica;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 150)
    private String apellidos;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(length = 20)
    private String sexo;

    @Column(name = "correo_electronico", nullable = false, unique = true, length = 150)
    private String correoElectronico;

    @Column(length = 20)
    private String telefono;

    @Column(name = "telefono_emergencia", length = 20)
    private String telefonoEmergencia;

    @Column(length = 200)
    private String direccion;

    @Column(length = 100)
    private String ciudad;

    @Column(length = 100)
    private String provincia;

    @Column(name = "codigo_postal", length = 15)
    private String codigoPostal;

    @Column(length = 100)
    private String pais;

    @Column(name = "grupo_sanguineo", length = 10)
    private String grupoSanguineo;

    private Double altura;

    private Double peso;

    @Column(length = 500)
    private String alergias;

    @Column(name = "enfermedades_previas", length = 1000)
    private String enfermedadesPrevias;

    @Column(name = "medicacion_actual", length = 1000)
    private String medicacionActual;

    @Column(length = 1000)
    private String observaciones;

    @Column(name = "numero_seguridad_social", length = 30, unique = true)
    private String numeroSeguridadSocial;

    @Column(name = "compania_aseguradora", length = 100)
    private String companiaAseguradora;

    @Column(name = "numero_poliza", length = 50)
    private String numeroPoliza;

    @Column(name = "contacto_emergencia_nombre", length = 100)
    private String contactoEmergenciaNombre;

    @Column(name = "contacto_emergencia_apellidos", length = 150)
    private String contactoEmergenciaApellidos;

    @Column(name = "contacto_emergencia_parentesco", length = 50)
    private String contactoEmergenciaParentesco;

    @Column(nullable = false)
    private boolean activo = true;

    @Column(name = "fecha_alta")
    private LocalDate fechaAlta;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medicoAsignado;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Cita> listaCitas = new ArrayList<>();

    public Paciente() {
        this.fechaAlta = LocalDate.now();
        this.activo = true;
    }

    public Paciente(Long id, String dni, String numeroHistoriaClinica, String nombre, String apellidos,
                    LocalDate fechaNacimiento, String sexo, String correoElectronico, String telefono,
                    String telefonoEmergencia, String direccion, String ciudad, String provincia,
                    String codigoPostal, String pais, String grupoSanguineo, Double altura, Double peso,
                    String alergias, String enfermedadesPrevias, String medicacionActual, String observaciones,
                    String numeroSeguridadSocial, String companiaAseguradora, String numeroPoliza,
                    String contactoEmergenciaNombre, String contactoEmergenciaApellidos,
                    String contactoEmergenciaParentesco, boolean activo, LocalDate fechaAlta,
                    Medico medicoAsignado, List<Cita> listaCitas) {
        this.id = id;
        this.dni = dni;
        this.numeroHistoriaClinica = numeroHistoriaClinica;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
        this.telefonoEmergencia = telefonoEmergencia;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.codigoPostal = codigoPostal;
        this.pais = pais;
        this.grupoSanguineo = grupoSanguineo;
        this.altura = altura;
        this.peso = peso;
        this.alergias = alergias;
        this.enfermedadesPrevias = enfermedadesPrevias;
        this.medicacionActual = medicacionActual;
        this.observaciones = observaciones;
        this.numeroSeguridadSocial = numeroSeguridadSocial;
        this.companiaAseguradora = companiaAseguradora;
        this.numeroPoliza = numeroPoliza;
        this.contactoEmergenciaNombre = contactoEmergenciaNombre;
        this.contactoEmergenciaApellidos = contactoEmergenciaApellidos;
        this.contactoEmergenciaParentesco = contactoEmergenciaParentesco;
        this.activo = activo;
        this.fechaAlta = fechaAlta;
        this.medicoAsignado = medicoAsignado;
        this.listaCitas = listaCitas != null ? listaCitas : new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNumeroHistoriaClinica() {
        return numeroHistoriaClinica;
    }

    public void setNumeroHistoriaClinica(String numeroHistoriaClinica) {
        this.numeroHistoriaClinica = numeroHistoriaClinica;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefonoEmergencia() {
        return telefonoEmergencia;
    }

    public void setTelefonoEmergencia(String telefonoEmergencia) {
        this.telefonoEmergencia = telefonoEmergencia;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getEnfermedadesPrevias() {
        return enfermedadesPrevias;
    }

    public void setEnfermedadesPrevias(String enfermedadesPrevias) {
        this.enfermedadesPrevias = enfermedadesPrevias;
    }

    public String getMedicacionActual() {
        return medicacionActual;
    }

    public void setMedicacionActual(String medicacionActual) {
        this.medicacionActual = medicacionActual;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getNumeroSeguridadSocial() {
        return numeroSeguridadSocial;
    }

    public void setNumeroSeguridadSocial(String numeroSeguridadSocial) {
        this.numeroSeguridadSocial = numeroSeguridadSocial;
    }

    public String getCompaniaAseguradora() {
        return companiaAseguradora;
    }

    public void setCompaniaAseguradora(String companiaAseguradora) {
        this.companiaAseguradora = companiaAseguradora;
    }

    public String getNumeroPoliza() {
        return numeroPoliza;
    }

    public void setNumeroPoliza(String numeroPoliza) {
        this.numeroPoliza = numeroPoliza;
    }

    public String getContactoEmergenciaNombre() {
        return contactoEmergenciaNombre;
    }

    public void setContactoEmergenciaNombre(String contactoEmergenciaNombre) {
        this.contactoEmergenciaNombre = contactoEmergenciaNombre;
    }

    public String getContactoEmergenciaApellidos() {
        return contactoEmergenciaApellidos;
    }

    public void setContactoEmergenciaApellidos(String contactoEmergenciaApellidos) {
        this.contactoEmergenciaApellidos = contactoEmergenciaApellidos;
    }

    public String getContactoEmergenciaParentesco() {
        return contactoEmergenciaParentesco;
    }

    public void setContactoEmergenciaParentesco(String contactoEmergenciaParentesco) {
        this.contactoEmergenciaParentesco = contactoEmergenciaParentesco;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Medico getMedicoAsignado() {
        return medicoAsignado;
    }

    public void setMedicoAsignado(Medico medicoAsignado) {
        this.medicoAsignado = medicoAsignado;
    }

    public List<Cita> getListaCitas() {
        return listaCitas;
    }

    public void setListaCitas(List<Cita> listaCitas) {
        this.listaCitas = listaCitas;
    }

    public void addCita(Cita cita) {
        this.listaCitas.add(cita);
    }

    public void removeCita(Cita cita) {
        this.listaCitas.remove(cita);
    }
}