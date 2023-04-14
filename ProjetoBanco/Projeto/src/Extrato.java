public class Extrato {
        private Conta pagouConta;
        private Conta recebeuConta;
        private String tipoTransferencia;
        private double valor;

        /**
         * Constuctor caso aja apenas deposito 
         * @param pagouConta    conta que recebeu dinheiro
         * @param valor         valor da transferencia (negativa (saque) ou positiva (deposito))
         * @param tipoTransferencia tipo de transferencia
         */
        public Extrato(Conta recebeuConta, double valor, String tipoTransferencia){
            this.recebeuConta = recebeuConta;
            this.valor = valor;
            this.tipoTransferencia = tipoTransferencia;
        }

        /**
         * Constuctor caso haja alguem que transferiu o dinheiro
         * @param recebeuConta conta que recebeu dinheiro
         * @param pagouConta    conta que enviou dinheiro
         * @param valor         valor da transferencia
         * @param tipoTransferencia tipo de transferencia
         */
        public Extrato(Conta recebeuConta, Conta pagouConta, double valor, String tipoTransferencia){
            this.recebeuConta = recebeuConta;
            this.pagouConta = pagouConta;
            this.valor = valor;
            this.tipoTransferencia = tipoTransferencia;
        }

        /**
         * Printa os dados do extrato
         */
        public void printExtrato(){
            if(pagouConta != null){
                System.out.println(tipoTransferencia + " | R$" + valor + " | R$" + recebeuConta.getSaldo() + " | Enviado por " + pagouConta.getNome());
            }else{
                 System.out.println(tipoTransferencia + " | R$" + valor + " | " + recebeuConta.getSaldo() + " | ");

            }
        }
}
