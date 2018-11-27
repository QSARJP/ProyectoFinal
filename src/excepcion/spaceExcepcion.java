package excepcion;


public class spaceExcepcion extends Exception{


	public static final String CONSTRUCCION_SALVE ="Opcion Salva en Construccion";
	public static final String CONSTRUCCION_ABRA ="Opcion Abra en Construccion";
	public static final String CONSTRUCCION_EXPORTE ="Opcion Exporte en Construccion";
	public static final String CONSTRUCCION_IMPORTE ="Opcion Importe en Construccion";
	public static final String CONSTRUCCION_REINICIAR ="Opcion Reiniciar en Construccion";
	public spaceExcepcion(String message){
		super(message);
	}
}