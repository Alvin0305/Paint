# JavaFX Paint App 🎨

A basic paint application built using **Java** and **JavaFX** that supports manual drawing through coordinate input and performs fundamental 2D **matrix transformations**. The app uses **Bresenham's line drawing algorithm** for rendering lines and triangles.

---

## ✨ Features

### 🖌️ Drawing
- **Dots**: Draw a single pixel by entering coordinates.
- **Lines**: Draw lines between two points using Bresenham’s Line Algorithm.
- **Triangles**: Draw triangles by entering three points. Automatically connects edges using lines.

### 🔁 Transformations
All transformations are applied to the **currently drawn shape(s)**. The app automatically **redraws** using Bresenham’s algorithm.

#### 1. **Translation**
- Translate shape by `dx` and `dy`.

#### 2. **Rotation**
- Rotate shape around:
  - A user-defined pivot point
  - The shape’s geometric **center**

#### 3. **Scaling**
- Scale shape:
  - **Uniformly** (same factor in both x and y)
  - **Non-uniformly** (different `sx` and `sy`)
- Pivot options:
  - Around a specific point
  - Around the shape's **center**

#### 4. **Move**
- Move shape directly to a new `(x, y)` location.

#### 5. **Show Current Location**
- Display the current coordinates of all relevant points of the shape.

---

## 🖼️ Technology Stack

- **Java**
- **JavaFX**
- **Custom implementation of Bresenham’s Line Drawing Algorithm**

---

## 🚀 Getting Started

### Prerequisites

- Java 17+
- JavaFX SDK properly configured in your system or IDE (e.g., IntelliJ or VS Code)

### Run the App

1. Clone the repo:
   ```bash
   git clone https://github.com/Alvin0305/Paint.git
   cd Paint
