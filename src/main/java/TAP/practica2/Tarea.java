package TAP.practica2;

public class Tarea {

	protected String titulo;
	protected String descripcion;
	protected String prioridad;
	protected String dia;
	protected String mes;
	protected String año;
	protected String fechaFin;
	protected Boolean completada;
	protected Boolean boolAux = false;
	protected int id;
	
	public Tarea(int id, String titulo, String descripcion, String dia, String mes, String año, String prioridad) {
		this.id = id;
		this.completada = false;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.dia = dia;
		this.mes = mes;
		this.año = año;
		this.fechaFin = this.dia + "/" + this.mes + "/" + this.año;
		this.prioridad = prioridad;
	}
	
	String getPrioridad() {
		return this.prioridad;
	}
	
	String getTitulo() {
		return this.titulo;
	}
	
	void completarTarea() {
		this.completada = true;
	}
	
	void descompletarTarea() {
		this.completada = false;
	}

	String infoTarea() {
				
		if (Boolean.compare(this.completada, false) == 1) {
			return "Titulo: " + this.titulo + "|  Descripcion: " + this.descripcion + "|  Prioridad: " + this.prioridad + "|  Fecha Fin: " + this.fechaFin + "|  Terminada: Si";
		}
		else{
			return "Titulo: " + this.titulo + "|  Descripcion: " + this.descripcion + "|  Prioridad: " + this.prioridad + "|  Fecha Fin: " + this.fechaFin + "|  Terminada: No";
		}
	}
}
