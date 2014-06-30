package be.vub.smappeerules.core.rule;

import be.vub.smappeerules.core.device.IDeviceComponent;

/**
 * Created by Jonas on 30/06/2014.
 */
public class Term implements ITerm {
    IDeviceComponent c;
    String method;

    public Term(IDeviceComponent c, String method) {
        this.c = c;
        this.method = method;
    }

    public void evaluate() {
       /* if (this.method "consumption" )
            case : ;
                break;
            case "production":
                break;
            case "on/off":
                break;
            case "on/off_duration":
        }
*/
    }

    @Override
    public String toRuleString() {
        return ;
    }
}
