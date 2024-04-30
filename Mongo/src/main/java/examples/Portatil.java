package examples;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

public class Portatil {

	private ObjectId id;

	@BsonProperty("tipo")
	private String tipo;

	@BsonProperty("marca")
	private String marca;

	@BsonProperty("modelo")
	private String modelo;

	@BsonProperty("precio")
	private float precio;

	@BsonProperty("pantalla")
	private String pantalla;

	@BsonProperty("procesador")
	private String procesador;

	@BsonProperty("ram")
	private String ram;

	@BsonProperty("almacenamiento")
	private String almacenamiento;

	@BsonProperty("graficos")
	private String graficos;

	@BsonProperty("so")
	private String so;

	@BsonProperty("color")
	private String color;

	public String getTipo() {
		return tipo;
	}

	public Portatil setTipo(String tipo) {
		this.tipo = tipo;
		return this;
	}

	public String getPantalla() {
		return pantalla;
	}

	public Portatil setPantalla(String pantalla) {
		this.pantalla = pantalla;
		return this;

	}

	public String getProcesador() {
		return procesador;
	}

	public Portatil setProcesador(String procesador) {
		this.procesador = procesador;
		return this;
	}

	public String getRam() {
		return ram;
	}

	public Portatil setRam(String ram) {
		this.ram = ram;
		return this;

	}

	public String getMarca() {
		return marca;
	}

	public Portatil setMarca(String marca) {
		this.marca = marca;
		return this;
	}

	public String getModelo() {
		return modelo;
	}

	public Portatil setModelo(String modelo) {
		this.modelo = modelo;
		return this;
	}

	public float getPrecio() {
		return precio;
	}

	public Portatil setPrecio(float precio) {
		this.precio = precio;
		return this;
	}

	public String getAlmacenamiento() {
		return almacenamiento;
	}

	public Portatil setAlmacenamiento(String almacenamiento) {
		this.almacenamiento = almacenamiento;
		return this;

	}

	public String getGraficos() {
		return graficos;
	}

	public Portatil setGraficos(String graficos) {
		this.graficos = graficos;
		return this;
	}

	public String getSo() {
		return so;
	}

	public Portatil setSo(String so) {
		this.so = so;
		return this;
	}

	public String getColor() {
		return color;
	}

	public Portatil setColor(String color) {
		this.color = color;
		return this;
	}

	public ObjectId getId() {
		return id;
	}

	public Portatil setId(ObjectId id) {
		this.id = id;
		return this;
	}

	public Object name() {
		return marca + " " + modelo;
	}

	@Override
	public String toString() {
		return "Ordenador portátil Marca=" + marca + ", Modelo=" + modelo + ", Precio=" + precio + ", procesador="
				+ procesador + ", Memoria RAM=" + ram + ", Almacenamiento=" + almacenamiento + ", Tarjeta Gráfica="
				+ graficos + ", Sistema Operativo=" + so + ", color=" + color;
	}

}
