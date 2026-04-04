# 🚀 Android Baseapp Template (Kotlin)

   

Molde profissional para desenvolvimento Android no VS Code, sem necessidade de abrir o Android Studio no dia a dia.

---

## ⚡ TL;DR (Execução rápida)

```bash
# 1. Configurar local.properties
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

## 🧠 Como funciona este template

Este projeto usa:

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
sdkmanager "platform-tools" "platforms;android-34" "build-tools;34.0.0"
```

---

## 🏗️ Passo 1: Configuração Inicial

### Antes de rodar qualquer build, o Android SDK precisa ser reconhecido pelo sistema e pelo VS Code. Isso é feito configurando a variável `ANDROID_HOME`.

---

### 1️⃣ Criar `local.properties`

Na raiz do projeto, crie o arquivo `local.properties`:

```
sdk.dir=C\\:\\Users\\SEU_USUARIO\\AppData\\Local\\Android\\Sdk
```

⚠️ Não subir este arquivo para o Git.

---

### 2️⃣ Configurar a variável ANDROID_HOME

Existem **três maneiras** de fazer isso no Windows:

#### 🔹 Método 1: Interface gráfica (recomendado para iniciantes)

1. Pressione **Windows + S** e digite **“variáveis de ambiente”**
2. Clique em **“Editar variáveis de ambiente do sistema”**
3. Em **Variáveis do Usuário → Novo…**, preencha:

   * Nome: `ANDROID_HOME`
   * Valor: `C:\Users\SEU_USUARIO\AppData\Local\Android\Sdk`
4. Clique em **OK** e reinicie o terminal/VS Code.

---

#### 🔹 Método 2: PowerShell permanente (para builds confiáveis)

```
[System.Environment]::SetEnvironmentVariable(
    "ANDROID_HOME",
    "C:\Users\SEU_USUARIO\AppData\Local\Android\Sdk",
    "User"
)
```

* `"User"` define que a variável é para o usuário atual.
* Reinicie o terminal/VS Code após aplicar.

---

#### 🔹 Método 3: Sessão temporária (teste rápido)

No **PowerShell**:

```
$env:ANDROID_HOME="C:\Users\SEU_USUARIO\AppData\Local\Android\Sdk"
```

Ou no **CMD**:

```
set ANDROID_HOME=C:\Users\SEU_USUARIO\AppData\Local\Android\Sdk
```

⚠️ Vale lembrar: **só dura enquanto o terminal estiver aberto**.

---

### 3️⃣ Por que isso é importante

* O `adb` e o Gradle usam **ANDROID_HOME** para localizar o SDK.
* Sem isso, você verá erros como:

  * `adb: command not found`
  * `SDK not found`
  * `Unresolved reference: R`

💡 **Dica:** Depois de configurar, sempre **reinicie o terminal ou o VS Code**.

---

## 📱 Passo 2: Emulador

### ▶️ Rodar

* Ctrl + Shift + P
* Run Emulator

---

### ⚙️ Criar (se necessário)

```powershell
sdkmanager "system-images;android-34;google_apis;x86_64"
./avdmanager create avd -n "Pixel_Base" -k "system-images;android-34;google_apis;x86_64" -device "pixel_3a"
```

---

## 🚀 Passo 3: Build

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

### Nome

```xml
<string name="app_name">MeuApp</string>
```

---

### ID

```kotlin
applicationId = "com.minha.app"
```

---

### Substituição

```
Ctrl + Shift + H
```

---

## ⚠️ Erros comuns

* adb não funciona → SDK errado
* Emulator não aparece → criar AVD
* Build falha → RESET
* Código vermelho → RESET

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

* Sempre iniciar emulador antes do build
* Use RESET sem medo
* Template reutilizável

---

## 🎯 Objetivo

Este projeto serve como base para:

* Estudos Android
* Projetos rápidos
* Evolução para apps mais complexos
