package policy;

import policy.SubmitPolicy;

public class LionPolicy implements SubmitPolicy {

  @Override
  public boolean canSubmit() {
    return true;
  }
}