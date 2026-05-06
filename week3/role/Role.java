package role;

import policy.SubmitPolicy;

public abstract class Role {

  protected String name;
  protected String major;
  protected int generation;
  protected String part;

  protected SubmitPolicy policy;

  public Role(String name, String major, int generation,
              String part, SubmitPolicy policy) {

    this.name = name;
    this.major = major;
    this.generation = generation;
    this.part = part;
    this.policy = policy;
  }

  public boolean canSubmitAssignment() {
    return policy.canSubmit();
  }

  public abstract void showInfo();
}