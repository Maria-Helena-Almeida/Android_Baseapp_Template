# 🚀 Android Baseapp Template (Kotlin)

Molde profissional para desenvolvimento Android no VS Code, sem necessidade de abrir o Android Studio no dia a dia.

---

## ⚡ TL;DR (Execução rápida)

```bash
# Terminal: VS Code (PowerShell)
# 1. Configurar local.properties + ANDROID_HOME
# 2. Iniciar emulador
# 3. Build
./gradlew clean installDebug

# 4. Abrir app
adb shell am start -n com.minha.baseapp/.MainActivity
```

---

## ✅ Pré-requisitos

* Java JDK 17+
* VS Code
* Android SDK
* PowerShell (Windows)

Opcional:

* Android Studio (apenas para setup inicial)

---

## 🧩 Extensões recomendadas (VS Code)

Estas são as extensões **essenciais para o funcionamento do projeto**:

### 🔹 Obrigatórias

* **Kotlin (fwcd.kotlin)**
  Essencial para trabalhar com arquivos `.kt` (ex: MainActivity.kt)

* **Extension Pack for Java (vscjava.vscode-java-pack)**
  Inclui suporte completo ao Java (necessário porque o Android usa a base Java)

* **Language Support for Java (Red Hat)**
  Responsável por análise de código, erros e autocomplete

* **Gradle for Java (vscjava.vscode-gradle)**
  Permite rodar builds (`gradlew`) e entender o `build.gradle.kts`

---

### 📱 Emulador (muito importante)

* **Android iOS Emulator (adpyke.vscode-android-ios-emulator)**
  Usado para listar, iniciar e gerenciar emuladores diretamente no VS Code

---

### 💡 Observação importante

* Após instalar as extensões → **reinicie o VS Code**
* Se algo não funcionar → geralmente é problema de extensão ou PATH

---

## 🧠 Como funciona este template

* Kotlin como linguagem principal
* Gradle para build
* Estrutura padrão Android (Activity-based)

Objetivo: acelerar criação de apps e exercícios.

---

## 📁 Estrutura do Projeto

```
app/
 ├── src/main/
 │   ├── java/        → Código Kotlin
 │   ├── res/         → UI e recursos
 │   └── AndroidManifest.xml
 ├── build.gradle.kts

gradlew → Script de build
```

---

# 📖 Guia Completo (Do Zero ao App Rodando)

---

## 🧱 Passo 0: Instalar o Android SDK

### 🟢 Opção 1 (Recomendada)

Instale Android Studio com:

* SDK
* AVD

Verifique:

```
C:\Users\SEU_USUARIO\AppData\Local\Android\Sdk
```

---

### 🟡 Opção 2 (Avançado)

```powershell
# Terminal: PowerShell (pode ser no VS Code)
sdkmanager "platform-tools" "platforms;android-34" "build-tools;34.0.0"
```

⚠️ Se `sdkmanager` não for reconhecido, execute pelo caminho completo:

```powershell
C:\Users\SEU_USUARIO\AppData\Local\Android\Sdk\cmdline-tools\latest\bin\sdkmanager.bat
```

---

## 🏗️ Passo 1: Configuração Inicial

### 1️⃣ Criar `local.properties`

Na raiz do projeto:

```
sdk.dir=C\\:\\Users\\SEU_USUARIO\\AppData\\Local\\Android\\Sdk
```

⚠️ Não subir este arquivo para o Git.
 Para isso no arquivo .gitignore inserir local.properties

---

### 2️⃣ Configurar ANDROID_HOME

#### Método recomendado (Interface gráfica)

* Windows + S → “variáveis de ambiente”
* Variáveis do usuário → Novo

  * Nome: ANDROID_HOME
  * Valor: C:\Users\SEU_USUARIO\AppData\Local\Android\Sdk

Reinicie o VS Code.

---

## 📱 Passo 2: Emulador 

### ▶️ Opção A: Usar emulador já existente (RECOMENDADO)


1. Ctrl + Shift + P (no VS Code )
2. Digite: Emulator
3. Clique: Run Emulator
4. Escolha dispositivo

---

### ⚠️ Problema comum: erro de PATH

Se aparecer erro tipo:

* `emulator not recognized`
* `sdkmanager not recognized`
* `avdmanager not recognized`

👉 Significa que o PATH do Android não está configurado.

---

### ✅ Como corrigir o PATH (OBRIGATÓRIO se deu erro)

1. Windows + S → “variáveis de ambiente”
2. Variáveis do usuário → editar variável **Path**
3. Adicione:

```
C:\Users\SEU_USUARIO\AppData\Local\Android\Sdk\platform-tools
C:\Users\SEU_USUARIO\AppData\Local\Android\Sdk\emulator
C:\Users\SEU_USUARIO\AppData\Local\Android\Sdk\cmdline-tools\latest\bin
```

4. Clique OK em tudo
5. **Reinicie o VS Code**

---
### ⚠️ Problema comum: cmdline-tools NÃO existe

Se não existir:

```
C:\Users\SEU_USUARIO\AppData\Local\Android\Sdk\cmdline-tools
```

👉 Você NÃO tem os **Command-line Tools** instalados.

#### ✅ Solução A (recomendada)

Android Studio → SDK Manager → SDK Tools
✔️ Android SDK Command-line Tools (latest)

---

#### 🟡 Solução B (sem Android Studio)

1. Baixe em:
   [https://developer.android.com/studio#command-tools](https://developer.android.com/studio#command-tools)

2. Extraia em:

```
C:\Users\SEU_USUARIO\AppData\Local\Android\Sdk\cmdline-tools
```

3. Ajuste a estrutura (OBRIGATÓRIO):

```
cmdline-tools/
   └── latest/
       └── bin/
```

---

### ⚙️ Opção B: Criar emulador do zero

#### 🟧 PowerShell (VS Code)

```powershell
sdkmanager "system-images;android-34;google_apis;x86_64"
avdmanager create avd -n Pixel_Base -k "system-images;android-34;google_apis;x86_64" -device "pixel_3a"
```

---

#### ⬜ CMD (alternativo)

```cmd
sdkmanager.bat "system-images;android-34;google_apis;x86_64"
avdmanager.bat create avd -n Pixel_Base -k "system-images;android-34;google_apis;x86_64" -device "pixel_3a"
```

---

### 🚀 Iniciar emulador manualmente (caso extensão falhe)

#### 🟧 PowerShell

```powershell
emulator -avd Pixel_Base
```

#### ⬜ CMD

```cmd
emulator.exe -avd Pixel_Base
```

---

## 🚀 Passo 3: Build

👉 Terminal: **VS Code (PowerShell)**

```powershell
./gradlew clean installDebug --no-configuration-cache
```

### ✅ Resultado

```
BUILD SUCCESSFUL
```

---

## 🆘 RESET (Se der erro)

```powershell
./gradlew --stop
rd /s /q .gradle
rd /s /q app/build
```

```powershell
./gradlew clean installDebug --no-configuration-cache
```

---

## 🏃 Passo 4: Rodar App

```powershell
adb shell am start -n com.minha.baseapp/.MainActivity
```

---

## 🛠️ Passo 5: Personalização

### ✏️ Nome do App

```xml
<string name="app_name">MeuApp</string>
```

📍 res/values/strings.xml

---

### 🆔 ID do App

```kotlin
applicationId = "com.SEUNOME.appnome"
```

📍 app/build.gradle.kts

---

### 🔄 Substituição global

```
com.minha.baseapp → com.SEUNOME.appnome
```

Atalho:

```
Ctrl + Shift + H
```

---

### 📁 Ajustar pastas

```
src/main/java/
```

---

## ⚠️ Erros comuns

* sdkmanager não funciona → usar caminho completo
* adb não funciona → SDK não configurado
* Emulator não aparece → criar AVD
* Build falha → RESET

---

## 🚀 Próximos passos

* Criar calculadora
* Consumir API
* Navegação entre telas
* Banco de dados local

---

## 🏁 Git

```powershell
git add .
git commit -m "Feat: Android base template"
git push origin main
```

---

## 💡 Dicas finais

* Sempre usar terminal do VS Code (PowerShell)
* Iniciar emulador antes do build
* Use RESET sem medo

---

## 🎯 Objetivo

Este projeto serve como base para:

* Estudos Android
* Projetos rápidos
* Evolução para apps mais complexos

