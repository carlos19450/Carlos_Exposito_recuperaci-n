package AventuraPorConsola;

public abstract class Habilidad {
        protected String comando;
        private String tipo;

        public Habilidad(String tipo) {
                this.tipo = tipo;
        }

        public String getTipo() {
                return tipo;
        }

        public void setTipo(String tipo) {
                this.tipo = tipo;
        }



        //abstract puedoRealizarAccion()
        public void explorarZona(Personaje personaje) {
        }

        public abstract String realizarAccion();
        @Override
        public String toString() {
                return "Habilidad{" +
                        "tipo='" + tipo + '\'' +
                        '}';
        }
}
