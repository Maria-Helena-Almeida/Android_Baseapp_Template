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
## ✅ Pré-requisitos (O que eu preciso?)

### 1. Java JDK 17+

O Android moderno exige a versão 17.

**Como saber se tenho:**

```bash
java -version
```

**Como instalar:**

Baixe o [OpenJDK 17 (Temurin)](https://adoptium.net/temurin/releases/?version=17)

💡 Dica: No instalador, marque **"Add to PATH"** e **"Set JAVA_HOME"**

---

### 2. VS Code & Terminais

* **PowerShell (Recomendado):** Terminal azul padrão do Windows
  Use-o dentro do VS Code (Atalho: `Ctrl + ``)

* **CMD:** Terminal clássico. Funciona, mas o PowerShell lida melhor com scripts `./gradlew`

---

### 3. Git

Necessário para clonar este projeto.

Instale em: https://git-scm.com/

---

### Opcional

* Android Studio (apenas para setup inicial)

---

## 🧩 Extensões recomendadas (VS Code)

Estas são as extensões essenciais para o funcionamento do projeto:

### 🔹 Obrigatórias

* **Kotlin (fwcd.kotlin)**
  Essencial para trabalhar com arquivos `.kt` e o VS Code entender Kotlin

* **Extension Pack for Java (vscjava.vscode-java-pack)**
  Suporte completo ao Java

* **Language Support for Java (Red Hat)**
  Autocomplete, erros e análise de código

* **Gradle for Java (vscjava.vscode-gradle)**
  Execução de builds e leitura do `build.gradle.kts`

---

### 📱 Emulador (muito importante)

* **Android iOS Emulator (adpyke.vscode-android-ios-emulator)**
  Permite iniciar e gerenciar emuladores direto no VS Code

---

### 💡 Observação importante

* Como instalar as extensões:

   - 1. Abra o VS Code.

   - 2. Clique no ícone de Quadrados (Extensions) no menu lateral esquerdo (ou Ctrl + Shift + X).

   - 3. Digite o nome da extensão

   - 4. Clique em Install.

* Após instalar extensões → reinicie o VS Code
  
* Se algo não funcionar → geralmente é problema de extensão ou PATH

---

## 🧠 Como funciona este template

* Kotlin como linguagem principal
* Gradle para build
* Estrutura padrão Android (Activity-based)

**Objetivo:** acelerar criação de apps e exercícios.

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

## 📖 Guia Completo (Do Zero ao App Rodando)

### 🏗️ Passo 0: Clonando o Projeto

Clique no botão verde **Code** no topo da página
Copie o link (URL)

No terminal:

```bash
git clone https://github.com/Maria-Helena-Almeida/Android_Baseapp_Template
```

Depois no VS Code:

* File → Open Folder
* Selecione a pasta criada

---

### 🧱 Passo 1: Instalar o Android SDK

#### 🟢 Opção 1: Via Android Studio (Recomendada)

Instale o [Android Studio](https://developer.android.com/studio)
seguindo este [Tutorial em Vídeo (2025)](https://www.youtube.com/watch?v=_i87e9P0QIk)

Ele instala automaticamente:

* SDK
* AVD

📍 Caminho padrão:

```
C:\Users\SEU_USUARIO\AppData\Local\Android\Sdk
```

💡 Dica: Evite espaços no nome do usuário

---

#### 🟡 Opção 2 (Sem Android Studio - Avançado)

Se você não quer o Android Studio, precisará baixar as "Command line tools" no site oficial do Android, extrair manualmente e configurar as variáveis de ambiente. Atenção: Só recomendo se você tiver pouco espaço em disco.

Baixe:

https://developer.android.com/studio#command-tools

⚠️ Atenção
Baixar as Command Line Tools é apenas o primeiro passo. Após extrair, você precisa rodar estes comandos no terminal para baixar o restante do SDK:

```bash
sdkmanager --licenses
sdkmanager "platform-tools" "platforms;android-34" "build-tools;34.0.0" "emulator"
```

Se não funcionar:

```
C:\Users\SEU_USUARIO\AppData\Local\Android\Sdk\cmdline-tools\latest\bin\sdkmanager.bat
```

---

### 🛠️ O que compõe um SDK completo (Além das Command Line Tools)

Para um projeto Android funcionar, a pasta do SDK precisa ter estas subpastas:

platform-tools: Contém o adb (essencial para comunicar com o celular/emulador).

build-tools: Contém os compiladores que transformam código em .apk.

platforms: Contém as bibliotecas de uma versão específica do Android (ex: Android 34).

emulator: O software que roda o celular virtual.

---

### 🏗️ Passo 2: Configuração Inicial (Obrigatório)
Agora vamos "avisar" ao projeto onde o seu SDK está escondido.

### 1️⃣ No VScode abrir o arquivo local.properties
Na raiz do projeto (onde fica o arquivo README), existe um arquivo chamado local.properties. 
Cole a linha abaixo, substituindo SEU_USUARIO pelo seu nome de usuário do Windows:

```
sdk.dir=C\:\\Users\\SEU_USUARIO\\AppData\\Local\\Android\\Sdk
```

---

###2️⃣ Protegendo seus dados (.gitignore)
Não queremos enviar o caminho do seu computador pessoal para o GitHub dos outros.

Abra o arquivo .gitignore na raiz do projeto.

Verifique se existe uma linha escrita local.properties. 

```
local.properties
```
Se não tiver, escreva-a no final do arquivo e salve.

---

#### 3️⃣ ANDROID_HOME

Windows + S → Variáveis de ambiente

Criar:

* Nome: ANDROID_HOME
* Valor: C:\Users\SEU_USUARIO\AppData\Local\Android\Sdk

Reinicie o VS Code.

---

### 📱 Passo 3: Emulador

#### ▶️ Usar emulador existente no VS code

* Ctrl + Shift + P
* Digite: Emulator
* Run Emulator

---

#### ⚠️ Erro de PATH

Se aparecer:

* emulator not recognized
* sdkmanager not recognized
* avdmanager not recognized

---

#### ✅ Corrigir PATH

1. Windows + S → “variáveis de ambiente”

2. Variáveis do usuário → editar variável **Path**

3. Adicionar:

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

#### ⚙️ Criar emulador

```bash
sdkmanager "system-images;android-34;google_apis;x86_64"
avdmanager create avd -n Pixel_Base -k "system-images;android-34;google_apis;x86_64" -device "pixel_3a"
```

---

#### 🚀 Iniciar manualmente

```bash
emulator -avd Pixel_Base
```

---

### 🚀 Passo 4: Build

```bash
./gradlew clean installDebug --no-configuration-cache
```

---

### 🆘 RESET

```bash
./gradlew --stop
rd /s /q .gradle
rd /s /q app/build
./gradlew clean installDebug --no-configuration-cache
```

---

### 🏃 Passo 5: Rodar App

```bash
adb shell am start -n com.minha.baseapp/.MainActivity
```

---

### 🛠️ Passo 6: Personalização

#### Nome do App

```xml
<string name="app_name">MeuApp</string>
```

📍 res/values/strings.xml

---

#### ID do App

```kotlin
applicationId = "com.SEUNOME.appnome"
```

📍 app/build.gradle.kts

---

#### Substituição global

```
com.minha.baseapp → com.SEUNOME.appnome
```

Atalho:

```
Ctrl + Shift + H
```

---

## ⚠️ Erros comuns

* sdkmanager não funciona → usar caminho completo
* adb não funciona → SDK não configurado
* emulator não aparece → criar AVD
* build falha → RESET

---

## 🚨 Comandos de Sobrevivência

| Comando                  | Função               |
| ------------------------ | -------------------- |
| `./gradlew clean`        | Limpa builds antigos |
| `./gradlew installDebug` | Compila e instala    |
| `adb shell am start`     | Abre o app           |

---

## 🆘 Botão de Pânico

1. Feche o emulador
2. Feche o VS Code
3. Apague:

```
.gradle
app/build
```

4. Abra novamente e rode:

```bash
./gradlew installDebug
```

---

## 🚀 Próximos passos

* Criar calculadora
* Consumir API
* Navegação entre telas
* Banco de dados local

---

## 🏁 Git

```bash
git add .
git commit -m "Feat: Android base template"
git push origin main
```

---

## 💡 Dicas finais

* Use PowerShell no VS Code
* Inicie o emulador antes do build
* Use RESET sem medo

---

## 🎯 Objetivo

Este projeto serve como base para:

* Estudos Android
* Projetos rápidos
* Evolução para apps mais complexos
