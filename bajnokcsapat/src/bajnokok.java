public class bajnokok {
    private String ev;
    private String bajnok;
    private String kupagy;

    public bajnokok(String ev, String bajnok, String kupagy) {
        this.ev = ev;
        this.bajnok = bajnok;
        this.kupagy = kupagy;
    }

    public String getEv() {
        return ev;
    }

    public String getBajnok() {
        return bajnok;
    }

    public String getKupagy() {
        return kupagy;
    }
}