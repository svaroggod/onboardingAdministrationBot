package BotUser;

public class BotUser {

    String hrName;
    String recName;
    String leadName;
    String infoToChange;

    boolean isHR;
    boolean isRec;
    boolean isLead;
    boolean isCandidates;
    boolean delHR;
    boolean delRec;
    boolean delLead;
    boolean HRInfo;
    boolean RecInfo;
    boolean LeadInfo;
    boolean addHR;
    boolean addRec;
    boolean addLead;
    boolean changeHR;
    boolean changeRec;
    boolean changeLead;
    boolean changeHRAccept;
    boolean changeHRAcceptInfo;
    boolean changeRecAccept;
    boolean changeRecAcceptInfo;
    boolean changeLeadAccept;
    boolean changeLeadAcceptInfo;


    public void setFlags() {

        setHR(false);
        setRec(false);
        setLead(false);

        setDelHR(false);
        setDelRec(false);
        setDelLead(false);

        setAddHR(false);
        setAddRec(false);
        setAddLead(false);

        setChangeHR(false);
        setChangeRec(false);
        setChangeLead(false);
        setCandidates(false);


    }


    public boolean isChangeLeadAccept() {
        return changeLeadAccept;
    }

    public void setChangeLeadAccept(boolean changeLeadAccept) {
        this.changeLeadAccept = changeLeadAccept;
    }

    public boolean isChangeLeadAcceptInfo() {
        return changeLeadAcceptInfo;
    }

    public void setChangeLeadAcceptInfo(boolean changeLeadAcceptInfo) {
        this.changeLeadAcceptInfo = changeLeadAcceptInfo;
    }

    public boolean isRecInfo() {
        return RecInfo;
    }

    public void setRecInfo(boolean recInfo) {
        RecInfo = recInfo;
    }

    public boolean isLeadInfo() {
        return LeadInfo;
    }

    public void setLeadInfo(boolean leadInfo) {
        LeadInfo = leadInfo;
    }

    public boolean isChangeRecAcceptInfo() {
        return changeRecAcceptInfo;
    }

    public void setChangeRecAcceptInfo(boolean changeRecAcceptInfo) {
        this.changeRecAcceptInfo = changeRecAcceptInfo;
    }

    public boolean isChangeRecAccept() {
        return changeRecAccept;
    }

    public void setChangeRecAccept(boolean changeRecAccept) {
        this.changeRecAccept = changeRecAccept;
    }

    public boolean isHRInfo() {
        return HRInfo;
    }

    public void setHRInfo(boolean HRInfo) {
        this.HRInfo = HRInfo;
    }

    public boolean isChangeHRAcceptInfo() {
        return changeHRAcceptInfo;
    }

    public void setChangeHRAcceptInfo(boolean changeHRAcceptInfo) {
        this.changeHRAcceptInfo = changeHRAcceptInfo;
    }

    public String getInfoToChange() {
        return infoToChange;
    }

    public void setInfoToChange(String infoToChange) {
        this.infoToChange = infoToChange;
    }

    public boolean isChangeHRAccept() {
        return changeHRAccept;
    }

    public void setChangeHRAccept(boolean changeHRAccept) {
        this.changeHRAccept = changeHRAccept;
    }

    public boolean isChangeHR() {
        return changeHR;
    }

    public void setChangeHR(boolean changeHR) {
        this.changeHR = changeHR;
    }

    public boolean isChangeRec() {
        return changeRec;
    }

    public void setChangeRec(boolean changeRec) {
        this.changeRec = changeRec;
    }

    public boolean isChangeLead() {
        return changeLead;
    }

    public void setChangeLead(boolean changeLead) {
        this.changeLead = changeLead;
    }

    public String getLeadName() {
        return leadName;
    }

    public void setLeadName(String leadName) {
        this.leadName = leadName;
    }

    public String getHrName() {
        return hrName;
    }

    public void setHrName(String hrName) {
        this.hrName = hrName;
    }

    public String getRecName() {
        return recName;
    }

    public void setRecName(String recName) {
        this.recName = recName;
    }

    public boolean isHR() {
        return isHR;
    }

    public void setHR(boolean HR) {
        isHR = HR;
    }

    public boolean isRec() {
        return isRec;
    }

    public void setRec(boolean rec) {
        isRec = rec;
    }

    public boolean isLead() {
        return isLead;
    }

    public void setLead(boolean lead) {
        isLead = lead;
    }

    public boolean isCandidates() {
        return isCandidates;
    }

    public void setCandidates(boolean candidates) {
        isCandidates = candidates;
    }

    public boolean isDelHR() {
        return delHR;
    }

    public void setDelHR(boolean delHR) {
        this.delHR = delHR;
    }

    public boolean isDelRec() {
        return delRec;
    }

    public void setDelRec(boolean delRec) {
        this.delRec = delRec;
    }

    public boolean isDelLead() {
        return delLead;
    }

    public void setDelLead(boolean delLead) {
        this.delLead = delLead;
    }

    public boolean isAddHR() {
        return addHR;
    }

    public void setAddHR(boolean addHR) {
        this.addHR = addHR;
    }

    public boolean isAddRec() {
        return addRec;
    }

    public void setAddRec(boolean addRec) {
        this.addRec = addRec;
    }

    public boolean isAddLead() {
        return addLead;
    }

    public void setAddLead(boolean addLead) {
        this.addLead = addLead;
    }
}
