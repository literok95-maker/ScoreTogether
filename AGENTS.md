# AGENTS.md

## 0. TL;DR для агента
- Проект: **ScoreTogether** — Android/Kotlin Multiplatform (модуль `:composeApp`, общий код в `:shared`).
- UI: **Jetpack Compose** (Material 3).
- Архитектура: **Clean Architecture + MVVM**.
- DI: **Koin**.
- Асинхронность: **Coroutines + Flow**.
- Сеть: **Ktor Client** (KMP) или **Retrofit/OkHttp** (Android).
- Тесты: **JUnit**, **MockK**, **Turbine**.
- ❗ Минимум правок в build-скриптах. **Не обновлять** версии зависимостей без необходимости.

---

## 1. Цели проекта
1. Реализовывать фичи инкрементально.
2. Соблюдать архитектуру и код-стайл.
3. Добавлять тесты.
4. В PR: описание, чеклист и скриншоты UI.

---

## 2. Среда и сборка

### Локально
- **JDK**: 17
- **Android Studio**: Iguana/Jellyfish+
- **AGP**: см. `gradle-wrapper.properties`
- **Kotlin**: последние стабильные версии
- **Android SDK**: API 34 (`build-tools;34.0.0`)

Команды:
```bash
./gradlew :composeApp:assembleDebug
./gradlew test
```

### В веб-песочнице (Codex/Claude)
Если нет Android SDK:
```bash
ANDROID_SDK_ROOT=/workspace/android-sdk
ANDROID_HOME=/workspace/android-sdk
PATH=$ANDROID_SDK_ROOT/cmdline-tools/bin:$ANDROID_SDK_ROOT/platform-tools:$PATH
```

---

## 3. Модульная структура
- `:composeApp` — Android UI (Compose, Navigation).
- `:shared` — KMP: domain + data.
- `:core:ui` — дизайн-система.
- `:core:network` — API.
- `:core:database` — БД.
- `:feature:<name>` — экраны/фичи.

---

## 4. Архитектура

### Слои
- **Presentation**: Compose + ViewModel
    - `UiState`, `UiEvent`, `UiEffect`
- **Domain**: UseCase + Entities
- **Data**: Repository + DataSource

### DI
- **Koin** (`appModule`, `dataModule`, `domainModule`, `featureXModule`)
- В Compose: `koinViewModel()`, `get()`

### Код-стайл
- Линтеры: `ktlint`, `detekt`
- Расширения: `*.ext.kt`
- Имена понятные, без аббревиатур

---

## 5. UI-паттерны (Compose)
- UDF: `Screen(state, onEvent)` → ViewModel → `stateFlow`
- Логика во ViewModel/UseCase, не в Composable
- Общие ресурсы в `:core:ui`
- Для Flow: `collectAsStateWithLifecycle()`

---

## 6. Сеть и БД
- **KMP**: Ktor + Kotlinx Serialization
- **Android**: Retrofit + OkHttp
- **БД**: SQLDelight (KMP) или Room (Android)

---

## 7. Тестирование
- **Unit**: JUnit + MockK
- **Coroutines/Flow**: `runTest`, Turbine
- **UI**: Espresso

Команды:
```bash
./gradlew testDebugUnitTest
./gradlew :shared:allTests
```

---

## 8. Примеры промптов

### Экран
```
Создай экран Login на Jetpack Compose (Material 3): поля email+password, кнопка “Sign in”, валидация; ViewModel с MVVM и State/Events/Effects, Koin-инжект репозитория. Тесты на ViewModel (успех/ошибка). Не меняй версии зависимостей.
```

### Репозиторий
```
Добавь AuthRepository с методом login(email, pass) через Ktor, обработку 401/500 и маппинг ошибок в доменную модель. Юнит-тесты с MockK, без изменения build-скриптов.
```

### Багфикс
```
Вот stacktrace сборки Gradle. Предложи минимальный фикс без обновления AGP/Kotlin. Если требуется SDK — укажи, какие пакеты поставить через sdkmanager.
```

---

## 9. Что нельзя
- ⛔ Обновлять версии Kotlin/AGP/Gradle без причины
- ⛔ Добавлять тяжёлые библиотеки
- ⛔ Смешивать UI и Data
- ⛔ Убирать линтеры/CI
- ⛔ Класть секреты в репозиторий

---

## 10. CI и линт
Перед PR:
```bash
./gradlew ktlintCheck detekt
./gradlew test
```

Форматирование:
```bash
./gradlew ktlintFormat
```

---

## 11. Частые проблемы
- **SDK location not found** → выставить `ANDROID_SDK_ROOT` и установить `platform-tools`, `build-tools;34.0.0`, `platforms;android-34`
- **Нет `bash` в песочнице** → использовать `/bin/sh`, ставить JDK/SDK в `$HOME`
- **ModuleNotFoundError: packaging** → `python3 -m pip install packaging`
- **Compose превью ломаются** → проверить версии BOM и Kotlin/AGP

---

## 12. Git
- Ветки:
    - `main` (стабильная)
    - `develop`
    - `feat/<scope>/<short>`

- Коммиты:
    - `feat: add login screen with M3 compose`
    - `fix: handle 401 in AuthRepository`
    - `test: add turbine tests for auth viewmodel`

---

## 13. Карта ключевых файлов
```
/composeApp/
  src/main/AndroidManifest.xml
  src/main/java/.../ui/...
  src/main/java/.../navigation/...
  src/main/java/.../di/AppModules.kt
/shared/
  src/commonMain/kotlin/.../domain/...
  src/commonMain/kotlin/.../data/...
  src/commonMain/kotlin/.../core/...
/core/ui/
/core/network/
/core/database/
build.gradle.kts
settings.gradle.kts
gradle/libs.versions.toml
```

---

## 14. Чеклист перед мерджем
- [ ] Сборка `:composeApp:assembleDebug` успешна
- [ ] Пройдены `ktlint`, `detekt`, `test`
- [ ] Архитектурные слои не нарушены
- [ ] DI корректен
- [ ] Публичный API задокументирован
- [ ] Скриншот/видео UI приложен (если менялся UI)  
