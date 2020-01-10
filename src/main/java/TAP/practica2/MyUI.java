package TAP.practica2;

import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.RadioButtonGroup;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 * @param <NumberField>
 */
@Theme("mytheme")
public class MyUI extends UI {

	@Override
	protected void init(VaadinRequest vaadinRequest) {
		
		ArrayList<Tarea> Tareas = new ArrayList<Tarea>();
		VerticalLayout layout = new VerticalLayout();
		setContent(layout);

		//BOTONES PRINCIPALES
		
		//Boton crear tarea
		Button btnNuevaTarea = new Button("Nueva Tarea");
		//Creo un boton para mostrar las tareas
		Button btnTareas = new Button("Mostrar Tareas");
		//Boton eliminar tareas
		//Button btnDeleteTarea = new Button("Eliminar Tareas");
		//Boton de modificar tareas
		Button btnModificarTareas = new Button("Completar Tarea");
		
		
		// CREAR TAREA

		//Etiquetas
		final TextField titulo = new TextField("Introduzca el título de la tarea: ", "");
		final TextField descripcion = new TextField("Introduzca la descripción de la tarea: ", "");
		final TextField dia = new TextField("Día Fin: ", "");
		final TextField mes = new TextField("Mes Fin: ", "");
		final TextField año = new TextField("Año Fin: ", "");
		
		RadioButtonGroup<String> prioridad = new RadioButtonGroup<>("Prioridad");
		prioridad.setItems("Baja", "Default", "Media", "Alta");
		
		
		
		
		
		
		Label ArrayTareas = new Label("Tareas: ");
		
		Label id = new Label ("ID: " + Tareas.size());
		
		/*numberField.setValue(1d);
		numberField.setHasControls(true);
		numberField.setMin(1);
		numberField.setMax(Tareas.size());
		*/
		
		//Añadimos los botones a la pantalla
		layout.addComponent(btnNuevaTarea);
		layout.addComponent(btnTareas);
		//layout.addComponent(btnDeleteTarea);
		layout.addComponent(btnModificarTareas);
		//layout.addComponent(ArrayTareas);
		
		
		//Boton para añadir la tarea
		Button btnAddTarea = new Button("Añadir Tarea");
		
		
		// MOSTRAR TAREAS

		//Cuando pulsamos el boton de mostrar tareas debemos poner los campos que lo componen visibles
		btnTareas.addClickListener(e -> {
			
			for (int i = 0; i < Tareas.size(); i++) {
				layout.addComponent(new Label("Tareas " + ": " + Tareas.get(i).infoTarea()));
			}
					
			//Ocultamos botones
			layout.removeComponent(btnTareas);
			
			//Mostramos botones
			layout.addComponent(btnNuevaTarea);
			layout.addComponent(btnTareas);
			//layout.addComponent(btnDeleteTarea);
			layout.addComponent(btnModificarTareas);
			
			
			
			
			
	
		});
				
		
		
		
		
		//Cuando pulsamos el boton crear tarea debemos poner los campos que lo componen visibles
		btnNuevaTarea.addClickListener(e -> {
			//Ocultamos botones
			layout.removeComponent(btnNuevaTarea);
			layout.removeComponent(btnTareas);
			//layout.removeComponent(btnDeleteTarea);
			layout.removeComponent(btnModificarTareas);
			layout.removeComponent(ArrayTareas);
			
			//Mostramos las etiquetas
			
			id.setValue("ID: " + Tareas.size());
			
			layout.addComponent(id);
			layout.addComponent(titulo);
			layout.addComponent(descripcion);
			layout.addComponent(dia);
			layout.addComponent(mes);
			layout.addComponent(año);	
			layout.addComponent(prioridad);
			
			
			//Mostramos el boton de añadir tarea
			layout.addComponent(btnAddTarea);
		});
		
		
		btnAddTarea.addClickListener(e -> {
			
			//Ocultamos etiquetas
			layout.removeComponent(id);
			layout.removeComponent(titulo);
			layout.removeComponent(descripcion);
			layout.removeComponent(dia);
			layout.removeComponent(mes);
			layout.removeComponent(año);
			layout.removeComponent(prioridad);
			
			
			
			
			System.out.println("Titulo de la tarea: " + titulo.getValue());
			System.out.println("Descripción de la tarea: " + descripcion.getValue());
			System.out.println("Fecha fin de la tarea: " + dia.getValue() + "/" + mes.getValue() + "/" + año.getValue());
			System.out.println("Prioridad tarea: " + prioridad.getValue());
			
			Tareas.add(new Tarea(Tareas.size(), titulo.getValue(), descripcion.getValue(), dia.getValue(), mes.getValue(), año.getValue(), prioridad.getValue()));
			/*
			 * SI QUEREMOS MOSTRAR 
			String TareasStr = "Tareas: ";
			for (int i = 0; i < Tareas.size(); i++) {
				TareasStr = TareasStr  + "\n" + Tareas.get(i).infoTarea();
				ArrayTareas.setValue(TareasStr);
			}
			
			*/
			
			//Ocultamos botones
			layout.removeComponent(btnAddTarea);
			
			//Mostramos botones
			layout.addComponent(btnNuevaTarea);
			layout.addComponent(btnTareas);
			//layout.addComponent(btnDeleteTarea);
			layout.addComponent(btnModificarTareas);
			//layout.addComponent(ArrayTareas);

		});
		
		
		/*
		
		//ELIMINAR TAREAS

		//Etiquetas
		final TextField titulormv = new TextField("Introdce el titulo de la tarea que deseas eliminar: ");

		//Boton para eliminar la tarea
		Button btnDelete = new Button("Eliminar");

		//Cuando pulsamos el boton elimibar producto debemos hacer las tareas visibles
		btnDeleteTarea.addClickListener(e -> {
			
			//Ocultamos botones
			layout.removeComponent(btnNuevaTarea);
			layout.removeComponent(btnTareas);
			layout.removeComponent(btnDeleteTarea);
			layout.removeComponent(btnModificarTareas);	
			layout.removeComponent(ArrayTareas);
			
			//Mostramos las etiquetas
			layout.addComponent(titulormv);
						
			//Mostramos el boton de eliminar
			layout.addComponent(btnDelete);
						
					
		});
		
		//Cuando pulsamos el boton de eliminar producto debemos eliminar la tarea
		btnDelete.addClickListener(e -> {
			
			System.out.println("Titulo de la tarea a eliminar: " + titulormv.getValue());
			
			for(int i = 0; i <= Tareas.size(); i++) {
				
				if(Tareas.get(i).getTitulo() == titulormv.getValue()) {
					Tareas.remove(i);
				}
			}
			
			//Ocultamos botones
			layout.removeComponent(btnDelete);
			
			//Mostramos botones
			layout.addComponent(btnNuevaTarea);
			layout.addComponent(btnTareas);
			layout.addComponent(btnDeleteTarea);
			layout.addComponent(btnModificarTareas);
			//layout.addComponent(ArrayTareas);
			
			
			System.out.println("Titulo de la tarea a eliminar: " + titulormv.getValue());
			
			for(int i = 0; i < Tareas.size(); i++) {
				System.out.println(Tareas.get(i).getTitulo());
				if(Tareas.get(i).getTitulo().equals(titulormv.getValue()) == true) {
					// PRUEBA: System.out.println(Tareas.get(i).infoTarea());
					Tareas.remove(i);
					// PRUEBA: System.out.println(Tareas.get(i).infoTarea());
					
				}
				//PRUEBA: else layout.addComponent(new TextField("Fallo"+ i));
			}
			
			//Ocultamos etiquetas
			layout.removeComponent(titulormv);
			
			//Ocultamos botones
			layout.removeComponent(btnDelete);
			
			//Mostramos botones
			layout.addComponent(btnNuevaTarea);
			layout.addComponent(btnTareas);
			layout.addComponent(btnDeleteTarea);
			layout.addComponent(btnModificarTareas);
			//layout.addComponent(ArrayTareas);
			
		});
		
		*/
		
		//COMPLETAR TAREAS

		//Etiquetas
		final TextField tituloCompletar = new TextField("Introdce el titulo de la tarea que deseas completar: ");

		//Boton para comoletar la tarea
		Button btnCompletar = new Button("Completar");

		//Cuando pulsamos el boton completar tarea debemos hacer las tareas visibles
		btnModificarTareas.addClickListener(e -> {
			
			//Ocultamos botones
			layout.removeComponent(btnNuevaTarea);
			layout.removeComponent(btnTareas);
			//layout.removeComponent(btnDeleteTarea);
			layout.removeComponent(btnModificarTareas);	
			//layout.removeComponent(ArrayTareas);
			
			//Mostramos las etiquetas
			layout.addComponent(tituloCompletar);
						
			//Mostramos el boton de eliminar
			layout.addComponent(btnCompletar);
						
					
		});
		
		//Cuando pulsamos el boton de eliminar producto debemos completar la tarea
		btnCompletar.addClickListener(e -> {
			
			System.out.println("Titulo de la tarea a completar: " + tituloCompletar.getValue());
			
			for(int i = 0; i < Tareas.size(); i++) {
				System.out.println(Tareas.get(i).getTitulo());
				if(Tareas.get(i).getTitulo().equals(tituloCompletar.getValue()) == true) {
					// PRUEBA: System.out.println(Tareas.get(i).infoTarea());
					Tareas.get(i).completarTarea();
					// PRUEBA: System.out.println(Tareas.get(i).infoTarea());
					
				}
				//PRUEBA: else layout.addComponent(new TextField("Fallo"+ i));
			}
			
			//Ocultamos etiquetas
			layout.removeComponent(tituloCompletar);
			
			//Ocultamos botones
			layout.removeComponent(btnCompletar);
			
			//Mostramos botones
			layout.addComponent(btnNuevaTarea);
			layout.addComponent(btnTareas);
			//layout.addComponent(btnDeleteTarea);
			layout.addComponent(btnModificarTareas);
			//layout.addComponent(ArrayTareas);
			
		});
		
	}

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false) 
    public static class MyUIServlet extends VaadinServlet {
    }
}
