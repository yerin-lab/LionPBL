package policy;

public class StaffPolicy implements SubmitPolicy {

  @Override
  public boolean canSubmit() {
    return false;
  }
}