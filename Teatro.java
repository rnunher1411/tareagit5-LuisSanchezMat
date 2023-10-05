/*
 * Clase Teatro.
 */
package comentandounaclase;


/**
 * Clase que representa un <strong>teatro</strong> y la gestión de sus obras y entradas.
 * <p>Los objetos de esta clase permiten almacenar y gestionar información sobre el propio teatro (código, nombre y aforo) así como de las obras que se están representando y de las entradas vendidas.</p>
 * <p>La clase también dispone de información general independiente de los objetos concretos que se hayan creado. Es el caso de:</p>
 * <ul>
 * <li><strong>número de teatros</strong> creados hasta el momento;</li>
 * <li><strong>cantidad total de obras activas</strong> en el momento actual, o</li>
 * <li><strong>cantidad total de entradas vendidas</strong> para todos los teatros y todas las obras.</li>
 * </ul>
 *
 * @author Luis
 * @version 2.0
 * @since 16/03/2023
 */
public class Teatro {
    
        /**
        * Máximo aforo permitido:  {@value AFORO_MAX} .
        */
        public static final int AFORO_MAX = 1000;
        
        /**
        * Mínimo aforo permitido:  {@value AFORO_MIN} .
        */
        public static final int AFORO_MIN = 300;  
        
        /**
        * Aforo por defecto:  {@value DEFAULT_AFORO} .
        */
        public static final int DEFAULT_AFORO = 800;
        
        private static int teatrosCreados=0;
        private static int cantidadEntradasVendidas=0;
        private static int totalObras=0;
        private String obra;
        private String nombreTeatro;
        private int codigoTeatro;
        private int aforoTeatro;
        
        /**
        * <p>Atributo al que se hace referencia para indicar el <strong>nombre</strong> de la obra que se representa.</p>
        */
        private String obraRepresentada;
        private int entradasVendidas;
        
        
        /**
        * Constructor basado en el nombre del teatro, así como en el aforo.
        * @param nombre nombre del teatro. 
        * @param aforo aforo del teatro.
        * @throws NullPointerException si el nombre del teatro es nulo
        * @throws IllegalArgumentException si alguno de los parámetros no es válido
        */
        public Teatro(String nombre, int aforo) throws NullPointerException, IllegalArgumentException{
            if(nombre == null){
                throw new NullPointerException ("El nombre del teatro no puede ser nulo");
            }else if(nombre.isEmpty()){
                throw new IllegalArgumentException("El nombre del teatro no puede ser cadena vacía");
            }else if( aforo > AFORO_MIN && aforo < AFORO_MAX){
                throw new IllegalArgumentException("Aforo incorrecto: " + aforo);
            }else{
              Teatro.teatrosCreados++;
              this.nombreTeatro = nombre;
              this.aforoTeatro = aforo;
              this.obraRepresentada = null;
              this.codigoTeatro = Teatro.teatrosCreados;

            }
        }
       
        /**
        * Constructor basado en el nombre del teatro.
        * @param nombre nombre del teatro. 
        * @throws NullPointerException si el nombre del teatro es nulo
        * @throws IllegalArgumentException si el nombre del teatro es una cadena vacía
        */
        public Teatro(String nombre){
            if(nombre == null){
                throw new NullPointerException ("El nombre del teatro no puede ser nulo");
            }else if(nombre.isEmpty()){
                throw new IllegalArgumentException("El nombre del teatro no puede ser cadena vacía");
            }else{
            Teatro.teatrosCreados++;
            this.nombreTeatro = nombre;
            this.aforoTeatro = DEFAULT_AFORO;
            this.obraRepresentada = null;
            this.codigoTeatro = Teatro.teatrosCreados;
            }
        }
        
        /**
        *Constructor sin parámetros ni excepciones.
        */
        public Teatro(){
          Teatro.teatrosCreados++;
          this.nombreTeatro = "Teatro " + Teatro.teatrosCreados;
          this.aforoTeatro = DEFAULT_AFORO;
          this.obraRepresentada = null;
          this.codigoTeatro = Teatro.teatrosCreados;
        }

        /**
        * Devuelve el código del teatro
        * @return Obtiene el código del teatro.
        */
        
        public int getCodigoTeatro(){
            return this.codigoTeatro;
        }
        
        /**
        * Devuelve el nombre del teatro
        * @return Obtiene el nombre del teatro.
        */
        
        public String getNombreTeatro(){
            return this.nombreTeatro;
        }
        
        /**
        * Devuelve el aforo del teatro
        * @return Obtiene el aforo del teatro.
        */
        
        public int getAforo(){  
            return this.aforoTeatro;
        }
        
        /**
        * Devuelve la cantidad de entradas vendidas
        * @return Obtiene las entradas vendidas para la obra que se está representando.
        */
        
        public int getEntradasVendidas(){          
            return this.entradasVendidas;
        }
        
        /**
        * Booleano que indica si el teatro tiene una obra asignada
        * @return true si el teatro tiene obra asignada o false si no es así.
        */
        
        public boolean tieneObra(){
            return this.obra != null;
        }
        
        /**
        * Devuelve el nombre de la obra que se está representando. Prueba de la etiqueta link: {@link Teatro}
        * @return el nombre de la obra representada
        */
        
        public String getObra(){
            return this.obraRepresentada;        
        }
        
        /**
        * Devuelve el número de teatros creados
        * @return Obtiene el número de teatros creados hasta el momento
        */
        
        public static int getTeatrosTotales(){
            return Teatro.teatrosCreados;
        }
        
        /**
        * Devuelve el número de obras activas
        * @return Obtiene el número de obras que se están representando en este momento en todos los teatros.
        */
        
        public static int  getObrasActivas(){
            return Teatro.totalObras;
        }
        
        /**
        * Devuelve las entradas vendidas en todos los teatros
        * @return Obtiene las entradas vendidas en todos los teatros y para todas las obras que se han representado hasta el momento.
        * @see <a href ="https://educacionadistancia.juntadeandalucia.es/centros/malaga/">Este enlace te redirige a la Moodle. Se trata de un ejemplo con la etiqueta see.</a>
        */
        
        public static int getEntradasVendidasTotales(){
            return Teatro.cantidadEntradasVendidas;
        }
        
        /**
        * Asigna una obra al teatro
        * Si el teatro ya tiene obra asignada no se puede volver a asignar.
        * @param obraRepresentada Obra que se va a asignar al teatro
        * @throws NullPointerException si el parámetro obra es nulo.
        * @throws IllegalArgumentException si el nombre de la obra es una cadena vacía o bien si el aforo no es correcto
        * @throws IllegalStateException si tiene obra asignada
        */
        
        public void asignarObra(String obraRepresentada)throws NullPointerException, IllegalArgumentException{
            if(obraRepresentada == null){
                throw new NullPointerException ("El nombre de la obra no puede ser nulo");
            }else if(obraRepresentada.isEmpty()){
                throw new IllegalArgumentException ("El nombre de la obra no puede ser cadena vacía");
            }else if (this.obra != null){
                throw new IllegalStateException("El teatro ya tiene una obra asignada");
            }else{
                Teatro.totalObras++;
                this.obraRepresentada = obraRepresentada;
             }
        }

        /**
        * Finaliza la obra que se está representando.
        * Si el teatro no tiene obra asignada no se puede finalizar.
        * @throws IllegalStateException si no tiene obra asignada
        */
        
        public void terminarObra()throws IllegalArgumentException{
            if (this.obra == null){     
                throw new IllegalStateException("El teatro no tiene una obra asignada que se pueda finalizar");
            }else{
                this.obra = null;
                Teatro.totalObras--;
             }
        }

        /**
        * Compra entradas para la obra que se está representando.
        * Si el teatro no tiene obra asignada no podrán comprarse entradas, y si el número de entradas supera el aforo, tampoco.
        * @deprecated
        * Este método está ficticiamente obsoleto. Únicamente se trata de probar la etiqueta 'deprecated'.
        * @param cantidad número de entradas a comprar
        * @throws IllegalArgumentException si entradas son 0 o negativas
        * @throws IllegalStateException si no tiene obra asignada o si el número de entradas supera el aforo
        */
        @Deprecated
        public void comprarEntradas(int cantidad) throws IllegalStateException,IllegalArgumentException {
            if(this.obra == null){
                throw new IllegalStateException ("El teatro no tiene una obra asignada, por tanto no se pueden comprar entradas");
            }else if(this.aforoTeatro > AFORO_MAX){
                throw new IllegalArgumentException ("El número de entradas supera el aforo, no pueden aumentarse las entradas");
            }else if(cantidad <=0){
                throw new IllegalArgumentException ("No se pueden comprar "+cantidad+" entradas");
            }else{
                this.entradasVendidas++;
                Teatro.cantidadEntradasVendidas++;
            }
        }
        
        /**
        * Compra una entrada para la obra que se está representando. 
        * Si el teatro no tiene obra asignada no podrán comprarse entradas, y si el número de entradas supera el aforo, tampoco.
        * @throws IllegalStateException si no tiene obra asignada o si el número de entradas supera el aforo
        */
        
        public void comprarEntrada(){
            if(this.obra == null){
                throw new IllegalStateException ("El teatro no tiene una obra asignada, por tanto no se pueden comprar entradas");
            }else if(this.aforoTeatro > AFORO_MAX){
                throw new IllegalArgumentException ("El número de entradas supera el aforo, no pueden aumentarse las entradas");
            }else{
                this.entradasVendidas++;
                Teatro.cantidadEntradasVendidas++;
            }
        }


        /**
        * Devuelve entradas para la obra que se está representando.
        * Si el teatro no tiene obra asignada no podrán delvolverse entradas, y si el número de entradas a devolver supera las entradas vendidas, tampoco.
        * @param cantidad número de entradas a devolver
        * @throws IllegalArgumentException si entradas son 0 o negativas
        * @throws IllegalStateException si no tiene obra asignada o si no hay tantas entradas vendidas
        */

        public void devolverEntradas(int cantidad)throws IllegalStateException,IllegalArgumentException {
            if(this.obra == null){
                throw new IllegalStateException ("El teatro no tiene una obra asignada, por tanto no pueden devolverse entradas");
            }else if(cantidad > this.entradasVendidas){
                throw new IllegalStateException ("No hay tantas entradas vendidas en este teatro, no pueden devolverse las entradas");
            }else if(cantidad <=0){
                throw new IllegalArgumentException ("No se pueden devolver "+cantidad+" entradas");
            }
            else{
                this.entradasVendidas = this.entradasVendidas - cantidad;
                Teatro.cantidadEntradasVendidas = Teatro.cantidadEntradasVendidas - cantidad;
            }
        
        }

        /**
        * Devuelve una entrada para la obra que se está representando.
        * Si el teatro no tiene obra asignada no podrán delvolverse entradas, y si no hay ninguna entrada vendida, tampoco.
        * @throws IllegalStateException si no tiene obra asignada o si no hay entradas vendidas
        */
        
        public void devolverEntrada(){
            if(this.obra == null){
                throw new IllegalStateException ("El teatro no tiene una obra asignada, por tanto no puede devolverse la entrada");
            }else{
                this.entradasVendidas--;
                Teatro.cantidadEntradasVendidas--;
            }
        }
        
        /**
        * Devuelve todas las entradas para vaciar el teatro para la obra que se está representando.
        * Si el teatro no tiene obra asignada no podrá vaciarse, y si ya está vacío, tampoco.
        * @throws IllegalStateException si no tiene obra asignada
        * @throws IllegalStateException si no tiene entradas vendidas
        */
        
        public void vaciarTeatro(){
            if(this.obra == null){
                throw new IllegalStateException ("El teatro no tiene una obra asignada, por tanto no puede vaciarse");
            }else if(cantidadEntradasVendidas == 0 || entradasVendidas == 0){
                //vigilar qué variable usar para las entradas vendidas
                throw new IllegalStateException ("El teatro no tiene entradas vendidas para esa obra, por tanto no puede vaciarse");
            }else{
                this.entradasVendidas = 0;                
                Teatro.cantidadEntradasVendidas = 0;
            }
        }
         
        /**
        * Compra todas las entradas para llenar el teatro para la obra que se está representando.
        * Si el teatro no tiene obra asignada no podrá llenarse, y si ya está lleno, tampoco.
        * @throws IllegalStateException si no tiene obra asignada
        * @throws IllegalStateException si no tiene entradas vendidas
        */
        
        public void llenarTeatro () {
            if(this.obra == null){
                throw new IllegalStateException ("El teatro no tiene una obra asignada, por tanto no puede llenarse");
            }else if (this.aforoTeatro > AFORO_MAX){
                throw new IllegalStateException ("El teatro ya estaba completo para esa obra, por tanto no puede llenarse");
            }else{
                this.aforoTeatro = AFORO_MAX;
            }
        }
        
        /**
        * Traspasa la obra que se está representando en este teatro a otro teatro.
        * Si este teatro no tiene obra asignada, no podrá traspasarse.
        * Tampoco podrá traspasarse si el teatro destino ya tiene una obra asignada o si el aforo es insuficiente para cubrir las entradas vendidas de la obra que se quiere traspasar.
        * @param miTeatro Teatro al que se va a traspasar la obra
        * @throws NullPointerException si el teatro destino es null
        * @throws IllegalStateException si este teatro no tiene obra asignada o si el teatro destino ya tiene una obra asignada o si el aforo es insuficiente para cubrir las entradas vendidas de la obra que se quiere traspasar.
        */
        
        public void traspasarObra (Teatro miTeatro ){
            if (miTeatro == null)    {
                throw new NullPointerException ("El teatro al que se está intentando traspasar la obra no existe");
            }else if(this.obra == null){
                throw new IllegalStateException ("El teatro actual no tiene una obra asignada, no puede traspasarse");
            }else if (this.obra != null){
                throw new IllegalStateException ("El teatro de respaldo tiene ya una obra asignada, no puede traspasarse");
            }else if (this.aforoTeatro > AFORO_MAX){
                throw new IllegalStateException ("Se supera el aforo del teatro de respaldo, no se puede realizar el traspaso");
            }
        }
        
        /**
        * Es el método característico de Java para representar el estado de un objeto.
        * @return una cadena que representa el estado de un objeto Teatro
        */
        
        @Override
        public String toString(){
            String asignada = this.tieneObra() ? "sí tiene una obra asignada" : "no tiene una obra asignada";
            String representa = this.obra == null ? "Representando la obra: ---" : "Representando la obra: " + this.obra;
                return String.format ("{ Nombre del teatro: %s; Código del teatro: %d;  Aforo: %d; %s; %s; Entradas vendidas: %d }",
                this.nombreTeatro,
                this.codigoTeatro,
                this.aforoTeatro,
                   asignada,
                   representa,
                   this.entradasVendidas);
    }
        

}
