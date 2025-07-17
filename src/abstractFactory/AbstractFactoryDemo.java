package abstractFactory;

class AbstractFactoryDemo {

    public static void main(String[] args) {
        ServiceFactory factory = new EmailServiceFactory(); // Try SMSServiceFactory

        Notification notification = factory.createNotification();
        Logger logger = factory.createLogger();

        notification.notifyUser();
        logger.log("Notification sent successfully");
    }

    // Abstract Factory Design Pattern - Object Creation loosely coupled to the factory
    interface ServiceFactory { Notification createNotification(); Logger createLogger(); }

    static class EmailServiceFactory implements ServiceFactory {
        public Notification createNotification() {
            return new EmailNotification();
        }
        public Logger createLogger() {
            return new FileLogger();
        }
    }

    static class SMSServiceFactory implements ServiceFactory {
        public Notification createNotification() {
            return new SMSNotification();
        }
        public Logger createLogger() {
            return new ConsoleLogger();
        }
    }

    // Concrete Products
    interface Logger { void log(String message); }
    static class FileLogger implements Logger { public void log(String message) {
            System.out.println("🗂️ Logging to File: " + message);
        } }
    static class ConsoleLogger implements Logger { public void log(String message) {
            System.out.println("🖥️ Logging to Console: " + message);
        } }

    // Concrete Products
    interface Notification { void notifyUser(); }
    static class EmailNotification implements Notification { public void notifyUser() {
            System.out.println("📧 Sending Email Notification");
        } }
    static class SMSNotification implements Notification { public void notifyUser() {
            System.out.println("📩 Sending SMS Notification");
        } }
}