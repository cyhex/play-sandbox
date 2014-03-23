import com.google.inject.AbstractModule;

public class GuiceModule extends AbstractModule {

    @Override
    protected void configure() {

      /*
      * Adding just one class  - not needed as its done by Guice Convention
      * bind(MyService.class);
      */

     /*
      * Bind Interface to Implementation
      *
      * This tells Guice that whenever it sees a dependency on a TransactionLog,
      * it should satisfy the dependency using a DatabaseTransactionLog.
      *
      * bind(TransactionLog.class).to(DatabaseTransactionLog.class);
      */

    }
}

