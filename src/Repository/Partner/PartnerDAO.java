package Repository.Partner;

import Domain.Partner.Partner;

public interface PartnerDAO {
    void createPartner(Partner partner);
    Partner getPartner(int partner_id);
    Partner getPartner(String username);
	int getPartnerID(String username);
}
