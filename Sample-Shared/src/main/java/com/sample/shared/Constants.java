package com.sample.shared;

public class Constants {

    private Constants() {
    }

    public static class Literals {

        public static final String HI = "Hi ";
        public static final String NAME = "Stranger";
        public static final String END = "! WelcomeService to our workshop.";
    }

    public static class Beans {

    	public static final String FEATURE_POJO = "FeaturePojo";
    	public static final String GREETING = "greeting";

    }

    public static class Controllers {

        public static class WelcomeController {

            public static final String PATH = "/welcome";

            public static class Welcome {

                public static final String PARAM_NAME = "name";
                public static final String PARAM_ID = "id";

                /* /{name} */
                public static final String PATH_NAME = "/{" + PARAM_NAME + "}";

                /* /{id} */
                public static final String PATH_ID = "/{" + PARAM_ID + "}";
                /* View constants */
                public static final String RESPONSE = "welcomeResponse";
            }
        }
    }

    public static class Services {

        public static class WelcomeService {

            public static final String SERVICE = "WelcomeService";
            /* Jersey path constants */
            public static final String PATH = "/welcomeService";

            public static class Welcome {

                public static final String NAME = "welcome";

                public static final String PARAM_NAME = "name";

                /* /welcome/{name} */
                public static final String PATH = "/" + NAME + "/{" + PARAM_NAME + "}";

            }

            public static class WelcomeId {

                public static final String NAME = "welcomeId";

                public static final String PARAM_ID = "id";

                /* /welcome/{id} */
                public static final String PATH = "/" + NAME + "/{" + PARAM_ID + "}";
            }
        }

        public static class FeatureService {

            public static final String SERVICE = "FeatureService";
            /* Jersey path constants */
            public static final String PATH = "/featureService";

            public static class Feature {

                public static final String NAME = "feature";

                public static final String PARAM_NAME = "name";

                /* /feature/{name} */
                public static final String PATH = "/" + NAME + "/{" + PARAM_NAME + "}";
            }
        }


    }

    public static class ServiceClients {

        /* http://localhost:8080/service/welcomeService/welcome */
        public static final String WELCOME = System.getProperty("ServiceURL") + Services.WelcomeService.PATH + "/" + Services.WelcomeService.Welcome.NAME;


        /* http://localhost:8080/service/welcomeService/welcomeId */
        public static final String WELCOME_ID = System.getProperty("ServiceURL") + Services.WelcomeService.PATH + "/" + Services.WelcomeService.WelcomeId.NAME;
    }
}
