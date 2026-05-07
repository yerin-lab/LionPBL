package policy;

import policy.SubmitPolicy;

public class StaffPolicy implements SubmitPolicy {

  @Override
  public boolean canSubmit() {
    return false;
  }
}