package examples;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

public class Sobremesa {

	private ObjectId id;

	@BsonProperty("tipo")
	private String tipo;

	@BsonProperty("marca")
	private String marca;

	@BsonProperty("modelo")
	private String modelo;

	@BsonProperty("precio")
	private float precio;

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

	public ObjectId getId() {
		return id;
	}

	public Sobremesa setId(ObjectId id) {
		this.id = id;
		return this;
	}

	public String getTipo() {
		return tipo;
	}

	public Sobremesa setTipo(String tipo) {
		this.tipo = tipo;
		return this;
	}

	public String getMarca() {
		return marca;
	}

	public Sobremesa setMarca(String marca) {
		this.marca = marca;
		return this;
	}

	public String getModelo() {
		return modelo;
	}

	public Sobremesa setModelo(String modelo) {
		this.modelo = modelo;
		return this;
	}

	public float getPrecio() {
		return precio;
	}

	public Sobremesa setPrecio(float precio) {
		this.precio = precio;
		return this;
	}

	public String getProcesador() {
		return procesador;
	}

	public Sobremesa setProcesador(String procesador) {
		this.procesador = procesador;
		return this;
	}

	public String getRam() {
		return ram;
	}

	public Sobremesa setRam(String ram) {
		this.ram = ram;
		return this;
	}

	public String getAlmacenamiento() {
		return almacenamiento;
	}

	public Sobremesa setAlmacenamiento(String almacenamiento) {
		this.almacenamiento = almacenamiento;
		return this;
	}

	public String getGraficos() {
		return graficos;
	}

	public Sobremesa setGraficos(String graficos) {
		this.graficos = graficos;
		return this;
	}

	public String getSo() {
		return so;
	}

	public Sobremesa setSo(String so) {
		this.so = so;
		return this;
	}

	public String getColor() {
		return color;
	}

	public Sobremesa setColor(String color) {
		this.color = color;
		return this;
	}

	@Override
	public String toString() {
		return "Ordenador de Sobremesa Marca="+ marca + ", Modelo=" + modelo + ", Precio="
				+ precio + ", procesador=" + procesador + ", Memoria RAM=" + ram + ", Almacenamiento=" + almacenamiento
				+ ", Tarjeta Gráfica=" + graficos + ", Sistema Operativo=" + so + ", color=" + color;
	}

	public String name() {
		return marca + " " + modelo ;
	}

	
}
