package fiap.contract.dto;

import java.time.LocalDateTime;


    public class ContractCreatedDTO {

        private int contractId;
        
        private LocalDateTime dataContract;

        public long getContractId() {
            return contractId;
        }

        public void setContractId(int contractId) {
            this.contractId = contractId;
        }

        public LocalDateTime getDataContract() {
            return dataContract;
        }

        public void setDataContract(LocalDateTime dataContract) {
            this.dataContract = dataContract;
        }
}
