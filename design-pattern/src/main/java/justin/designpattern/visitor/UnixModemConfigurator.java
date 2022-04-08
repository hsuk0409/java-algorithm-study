package justin.designpattern.visitor;

public class UnixModemConfigurator implements ModemVisitor {

    @Override
    public void visit(HayesModem modem) {
        modem.configurationString = "justin";
    }

    @Override
    public void visit(ZoomModem modem) {
        modem.configurationValue = 42;
    }

    @Override
    public void visit(ErnieModem modem) {
        modem.internalPattern = "C is too slow";
    }
}
