package AventuraPorConsola;

public class Habilidad {
        private String tipo;

        public Habilidad(String tipo) {
                this.tipo = tipo;
        }

        public void aplicarEfecto(Personaje personaje) {
        }

        public void quitarEfecto(Personaje personaje) {
        }

        public void moverse(Personaje personaje) {
        }

        @Override
        public String toString() {
                return "Habilidad{" +
                        "tipo='" + tipo + '\'' +
                        '}';
        }
}
