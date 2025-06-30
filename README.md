# 🖌️ Java Swing Paint App with Real-time Collaboration

## 👤 Author  
**Daniel Miuta**

## 📦 Repository Links  
- 🎨 Main Project: [Java-Swing-Paint-App-with-Sockets](https://github.com/DanielMiuta24/Java-Swing-Paint-App-with-Sockets)  
- 📚 Java Class Projects: [JavaClass Repository](https://github.com/DanielMiuta24/JavaClass)

---

## 📘 Project Overview

This project is a **real-time collaborative drawing application** built using **Java Swing** and **WebSocket** technology. It allows multiple users to log in, draw simultaneously on a shared canvas, and see each other's cursor positions with usernames in real time. Drawing tools, file handling, and synchronization are all supported. The project demonstrates advanced concepts such as GUI design, concurrent networking, event handling, and modular software design.

---

## ✅ Implemented Features

| Feature Description                                      | Status |
|----------------------------------------------------------|--------|
| User Registration & Login                                | ✅     |
| WebSocket communication for real-time updates            | ✅     |
| Cursor tracking (with usernames)                         | ✅     |
| Drawing tools: pencil, eraser, rectangle, ellipse, line  | ✅     |
| Fill tool with recursive fill                            | ✅     |
| Canvas clearing                                          | ✅     |
| File open/save with ImageIO                              | ✅     |
| Concurrent clients & thread safety                       | ✅     |
| Exception handling and validation                        | ✅     |

---

## 🧠 Technologies Used

| Component        | Library / Technology                   |
|------------------|----------------------------------------|
| GUI              | Java Swing                             |
| Drawing          | `Graphics2D`, `BufferedImage`          |
| File IO          | `ImageIO`, `JFileChooser`, `FileDialog`|
| Networking       | `org.java_websocket`                   |
| Authentication   | In-memory via WebSocket messages       |
| Data Structures  | `ConcurrentHashMap`, `ArrayList`       |

---

## 📍 Concepts and Where They Were Used

### ✅ 1. **Polymorphism**
- Used in the `DrawingTools` class which defines multiple shape-drawing methods like `drawRectangle`, `drawEllipse`, `drawLine`.
- Each method accepts a common interface (stroke, coordinates, Graphics2D) and executes shape-specific logic.
- Example:
  ```java
  public void drawRectangle(Stroke stroke, int x, int y, int width, int height, Graphics2D g) { ... }
  ```

### ✅ 2. **Exception Handling**
- Extensively used to ensure safe execution:
  - File open/save (`IOException`)
  - Image processing (`Base64 decoding`, `ImageIO.read`)
  - WebSocket communication (`URISyntaxException`, `InterruptedException`)
- Example:
  ```java
  try {
      ImageIO.write(b_map, "png", baos);
  } catch (IOException ex) {
      System.err.println("Error broadcasting canvas state: " + ex.getMessage());
  }
  ```

### ✅ 3. **HashMap / ConcurrentHashMap**
- Used to store cursor positions of other users:
  ```java
  private final Map<String, Point> otherUserCursors = new ConcurrentHashMap<>();
  ```
- This ensures **thread-safe updates** when multiple users are moving their cursors. The UI updates based on the latest cursor data received via WebSocket.
- Displayed in `paintComponent`:
  ```java
  g2.drawString(name, p.x + 12, p.y - 12);
  g2.fillOval(p.x, p.y, 6, 6);
  ```

### ✅ 4. **File Handling**
- Used to open and save drawings using `JFileChooser` and `ImageIO`.
- Open: Reads image from file and converts to `BufferedImage`.
- Save: Exports `BufferedImage` as PNG.

### ✅ 5. **Graphics2D**
- Central to all drawing operations:
  - Tools like pencil, eraser, and shapes are implemented using `Graphics2D` methods: `drawLine`, `drawOval`, `fillRect`, etc.
- Custom stroke width and anti-aliasing for smooth visuals.

### ✅ 6. **WebSocket Communication**
- Real-time data exchange for:
  - Authentication (`login:username:password`)
  - Canvas image sync (`update_img:<base64>`)
  - Cursor sync (`cursor:username:x:y`)
- Implemented using `org.java_websocket.client.WebSocketClient`.
- Supports multiple users connected to the same canvas.

---

## 👥 Pair Programming & Contributions

### 🔧 1. **Brainfuck Interpreter** with [Tammino](https://github.com/Tam-DHBW/dhbw-programming)
- I implemented [`Lexer.java`](https://github.com/Tam-DHBW/dhbw-programming/blob/1cdf2788a66c1f4765b0c2f43adb18ce7be0b76d/brainfuck/src/main/java/dhbw/mos/brainfuck/Lexer.java)
- This class is responsible for:
  - Parsing Brainfuck code into `Token` enums
  - Handling characters: `+`, `-`, `<`, `>`, `[`, `]`, `,`, `.`, `x`
  - Validating characters with error handling

### 🔧 2. **Grade System** with [Brien](https://github.com/DanielMiuta24/JavaClass/tree/main/Semester2/GradeSystem)
- I implemented the full application logic in Java.
- Brien contributed by designing the **class diagrams**, which helped define the structure and relationships between classes.
- No database was used — focus was on the class model.

---

## 💬 ChatGPT Usage

> ChatGPT was used **only for research** and **code suggestions**. All logic and code were written by me, with assistance only for understanding how to approach certain Java-specific implementations or syntax.

---



---

## 📂 Project Structure Overview

```
Java-Swing-Paint-App-with-Sockets/
├── client/
│   ├── PaintForm.java             # Main JFrame and UI
│   ├── DrawingTools.java          # Handles drawing logic
│   ├── FileDialogHandler.java     # Handles file open/save
├── server/
│   ├── WebSocketServerHandler.java  # Handles user sessions and messaging
│   └── UserDatabaseManager.java     # Manages user auth (in-memory)
├── resources/
│   └── icons/                     # PNG icons for buttons
```

---


