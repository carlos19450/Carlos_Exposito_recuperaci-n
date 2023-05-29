package AventuraPorConsola;

public class Habilidad {
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

        public void aplicarEfecto(Personaje personaje) {
        }

        public void quitarEfecto(Personaje personaje) {
        }

        public void moverse(Personaje personaje) {
        }
        //abstract realizarAccion()
        //abstract puedoRealizarAccion()
        public void explorarZona(Personaje personaje) {
        }

        @Override
        public String toString() {
                return "Habilidad{" +
                        "tipo='" + tipo + '\'' +
                        '}';
        }
}
