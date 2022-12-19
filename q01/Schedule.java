class Schedule extends BinarySearchTree {
  public static void main(String[] args) {
    Schedule s = new Schedule();
    s.addName("Enrell");
    s.addPhone("1234");
    s.addEmail("enrell@");
    s.addAddress("Rua Tal");
    s.addSocial("Facebook");
    s.addSocial("instagram");
    s.print(s.root);

    }
  BinarySearchTree name = new BinarySearchTree();
  BinarySearchTree phone = new BinarySearchTree();
  BinarySearchTree email = new BinarySearchTree();
  BinarySearchTree address = new BinarySearchTree();
  BinarySearchTree social = new BinarySearchTree();

  public Schedule() {
  }
  public void addName(String value) {
    name.insert(value);
  }
  public void addPhone(String value) {
    phone.insert(value);
  }
  public void addEmail(String value) {
    email.insert(value);
  }
  public void addAddress(String value) {
    address.insert(value);
  }
  public void addSocial(String value) {
    social.insert(value);
  }

  public void editName(String oldValue, String newValue) {
    name.edit(name.root, oldValue, newValue);
  }

  public void editPhone(String oldValue, String newValue) {
    phone.edit(phone.root, oldValue, newValue);
  }

  public void editEmail(String oldValue, String newValue) {
    email.edit(email.root, oldValue, newValue);
  }

  public void editAddress(String oldValue, String newValue) {
    address.edit(address.root, oldValue, newValue);
  }

  public void editSocial(String oldValue, String newValue) {
    social.edit(social.root, oldValue, newValue);
  }

  // Classe Schedule
public void removeName(String value) {
  name.remove(name.root, value);
}

public void removePhone(String value) {
  phone.remove(phone.root, value);
}

public void removeEmail(String value) {
  email.remove(email.root, value);
}

public void removeAddress(String value) {
  address.remove(address.root, value);
}

public void removeSocial(String value) {
  social.remove(social.root, value);
}

  public void search(String value) {
    if (name.sch(name.root, value)) {
      System.out.println("Find name: " + name.root.data);
    } if (phone.sch(phone.root, value)) {
      System.out.println("Find phone: " + phone.root.data);
    } if (email.sch(email.root, value)) {
      System.out.println("Find Email: " + email.root.data);
    } if (address.sch(address.root, value)) {
      System.out.println("Find address: " + address.root.data);
    } if (social.sch(social.root, value)) {
      System.out.println("Find social: " + social.root.data);
    }
  }

  // Print the tree
  public void print(Node root) {
    if (name.root == null) {
      System.out.println("Name: Empty");
    } else {
      System.out.println("Name: " + name.root.data);
      System.out.println("key: "+ name.root.key);
    } if (phone.root == null) {
      System.out.println("Phone: Empty");
    } else {
      System.out.println("Phone: " + phone.root.data);
      System.out.println("key: "+ phone.root.key);
    } if (email.root == null) {
      System.out.println("Email: Empty");
    } else {
      System.out.println("Email: " + email.root.data);
      System.out.println("key: "+ email.root.key);
    } if (address.root == null) {
      System.out.println("Address: Empty");
    } else {
      System.out.println("Address: " + address.root.data);
      System.out.println("key: "+ address.root.key);
    } if (social.root == null) {
      System.out.println("Social: Empty");
    } else {
      System.out.println("Social: " + social.root.data);
      System.out.println("key: "+ social.root.key);
    }
  }
}
