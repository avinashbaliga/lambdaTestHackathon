# 🚀 **Behavior-Driven Test Automation Framework**

A modular and scalable test automation framework using **Java**, **Cucumber**, **TestNG**, and **Selenium**, designed for both local and cloud-based executions (via LambdaTest).

---

## 🧰 Tools & Technologies

### 🖥️ Programming Language
- **Java 22**

### 🧪 Automation & Test Tools
- Selenium – Browser automation
- TestNG – Test execution framework
- Cucumber – BDD support
- Gherkin – To write feature files
- Log4j – For logging

---

## ▶️ How to Execute Tests

### 🧠 Using IntelliJ IDEA

1. **Clone the repository**
2. **Configure test execution**:
   - Go to **Run > Edit Configurations**
   - Add a new TestNG configuration with the following:
      - **VM options**: Add system variables (**prefix with `-D`**):
        ```bash
        -DloginUsername=yourHerokuUsername
        -DloginPassword=yourHerokuPassword
        -DlambdaTestUsername=yourLambdaTestUsername
        -DlambdaTestAccessKey=yourLambdaTestKey
        ```
      - **Test kind**: `Class`
      - **Class**: `runners.TestNGRunner`
      - Give your configuration a name, click **Apply**, then **OK**
3. Click the **Run (▶️)** button to start tests

---

## 🛠 Capabilities

### ☁️ Execution Platform
- Supports both **local** and **remote** execution on [LambdaTest](https://www.lambdatest.com/)
- Set in: [`testConfig.properties`](src/main/resources/testConfig.properties)

### 📊 Test Report
- Report is generated in **HTML** format after execution
- Path: [`target/test_report.html`](target/test_report.html)

### ⚙️ Execution Type
- Supports both **sequential** and **parallel** execution
- Set in: [`TestNGRunner.java`](src/test/java/runners/TestNGRunner.java)

---

## ❓ FAQ

> **1. Why Java?**  
> It’s fast, widely adopted, and has strong open-source tooling.

> **2. Why BDD/Cucumber?**  
> Promotes collaboration between product, dev, and QA teams. Test scenarios are written in human-readable format and stored in `.feature` files that are easy to share and maintain.

> **3. Why Log4j?**  
> One of the most powerful and easy-to-integrate logging frameworks for Java.

> **4. Can I run scenarios in parallel?**  
> Yes! Both parallel and sequential execution are supported. Configure in:  
> [`TestNGRunner.java`](src/test/java/runners/TestNGRunner.java)

> **5. LambdaTest testIds**  
> BHCP0-GKSQD-AR4ED-GHGJL  
> JLVTU-S8HJX-NSWLA-DW1CL  
> Y3FL9-RLARL-YC9JN-19KHU  
> WVZBW-CEFUB-I61BU-RYUPS  
> EANLK-RMLBH-AJIQT-C0UBT

---

🔗 _Need help? Open an issue or reach out!_
