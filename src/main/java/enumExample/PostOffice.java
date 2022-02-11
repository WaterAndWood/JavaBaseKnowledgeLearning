package enumExample;

/**
 * @author wangzhen
 * @creatTime 2022/2/10 10:38 下午
 * @description 常量方法实现职责链。模拟邮局投递信件，不断尝试处理信件，直到确定为一封死信。
 * 每次尝试是一个策略，完整处理方式列表就是一个职责链
 */
public class PostOffice {
    /**
     * 每个enum都对应一种策略，并添加策略方法
     */
    enum MailHandler {
        GENERAL_DELIVERY {
            @Override
            boolean handle(Mail m) {
                switch (m.generalDelivery) {
                    case YES:
                        System.out.println("Using general delivery for " + m);
                        return true;
                    default:
                        return false;
                }
            }
        },
        MACHINE_SCAN {
            @Override
            boolean handle(Mail m) {
                switch (m.scannability) {
                    case UNSCANNABLE:
                        return false;
                    default:
                        switch (m.address) {
                            case INCORRECT:
                                return false;
                            default:
                                System.out.println("Delivering " + m + "automatically");
                                return true;
                        }
                }
            }
        },
        VISUAL_INSPECTION {
            @Override
            boolean handle(Mail m) {
                switch (m.readability) {
                    case ILLEGIBLE:
                        return false;
                    default:
                        switch (m.address) {
                            case INCORRECT:
                                return false;
                            default:
                                System.out.println("Delivering" + m + "normally");
                                return true;
                        }
                }
            }
        };
        abstract boolean handle(Mail m);
    }

    /**
     * values()返回责任链的策略数组，遍历数组即遍历责任链
     * @param m
     */
    static void handleMail(Mail m) {
        for (MailHandler handler: MailHandler.values()) {
            if (handler.handle(m)) {
                return ;
            }
        }
        System.out.println("Mail is dead");
    }

    public static void main(String[] args) {
        Mail mail1 = Mail.getMail();
        Mail mail2 = Mail.getMail();
        System.out.println(mail1);
        handleMail(mail1);
        System.out.println(mail2);
        handleMail(mail2);
    }
}
class Mail {
    enum GeneralDelivery {YES, NO1, NO2, NO3, NO4}
    enum Scannability {UNSCANNABLE, YES1, YES2, YES3, YES4}
    enum Readability {ILLEGIBLE, YES1, YES2, YES3, YES4}
    enum Address {INCORRECT, OK1, OK2, OK3, OK4}
    GeneralDelivery generalDelivery;
    Scannability scannability;
    Readability readability;
    Address address;
    static long counter = 0;
    long id = counter++;
    @Override
    public String toString() {
        return "Mail " + id;
    }

    public String details() {
        return toString() + " General Delivery:" + generalDelivery +
                " Scannablilty: " + scannability + " Readability: " + readability +
                " Address: " + address;
    }
    public static Mail getMail() {
        Mail m = new Mail();
        m.generalDelivery = GeneralDelivery.YES;
        m.scannability = Scannability.UNSCANNABLE;
        m.readability = Readability.ILLEGIBLE;
        m.address = Address.INCORRECT;
        return m;
    }
}

/**
 * output:
 * Mail 0
 * Using general delivery for Mail 0
 * Mail 1
 * Using general delivery for Mail 1
 */
