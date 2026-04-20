# Third-Party Dependency Audit (Android + Python)

**Research Use Only. Not for clinical use.**

## Goal

Document a repeatable process to:
- identify third-party dependencies and licences
- detect known vulnerabilities (CVE advisories)
- produce artefacts suitable for a public release gate

## Release Gate (Minimum)

Before a public release:
- no known **critical** vulnerabilities with credible exploitation paths remain unaddressed, or there is a documented risk acceptance with mitigation
- dependency lists and licences are produced and stored as release artefacts (or in a private CI log, if you prefer)

## Android (Gradle)

### Dependency Inventory

Run in `android-genus-minimal/`:
- `./gradlew :app:dependencies`

Capture:
- direct dependencies
- transitive dependencies
- Android Gradle Plugin and Kotlin versions

### Vulnerability Checks

Options:
- Use GitHub Advisory / Dependabot (recommended when hosted on GitHub).
- Use an SCA tool integrated in CI (e.g., Gradle-based scanners).

### Licence Review

At minimum, identify licences for:
- androidx packages
- media/audio dependencies (if added later)
- any analytics/crash reporting SDKs (should be avoided by default)

## Python

### Dependency Inventory

If Python scripts require third-party libraries:
- use a virtual environment
- pin exact versions in a lock file (recommended)

Commands:
- `python -m pip freeze > requirements-lock.txt`

### Vulnerability Checks

Options:
- `pip-audit` (PyPI advisory database)
- `safety` (if used in your environment)

### Licence Review

Identify licences for any non-stdlib dependencies and confirm compatibility with `LICENSE` (Mulan PSL v2).

## SBOM (Software Bill of Materials)

This repository does not enforce a specific SBOM format, but preferred output is CycloneDX.

Recommended:
- produce SBOMs as CI artefacts per release tag
- store them with the release (not necessarily committed to the repository)

## Evidence to Attach to a Release

- dependency inventory outputs (Android and Python)
- vulnerability scan results (date-stamped)
- a short statement of residual risk and mitigations

