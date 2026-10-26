@echo off
rem git.bat - applies my Git setup on a new machine / fresh clone.
rem Usage: run it from cmd, from the root of the repository:  git.bat

setlocal

rem ---------------------------------------------------------------
rem 1) Global settings (once per machine)
rem ---------------------------------------------------------------
rem Pager: quit automatically when the output fits on one screen
git config --global core.pager "less -FRX"

rem ---------------------------------------------------------------
rem 2) Per-clone settings (once per clone of the repository)
rem ---------------------------------------------------------------
rem Files that stay tracked in the remote, but whose local changes
rem I don't want Git to see. Paths relative to the repo root,
rem each one between double quotes, separated by spaces.
set SKIP_FILES="path/to/file1" "path/to/file2"

rem Make sure we are inside a Git repository
git rev-parse --is-inside-work-tree >nul 2>&1
if errorlevel 1 (
  echo Not inside a Git repository. Run this from the repo root.
  exit /b 1
)

for %%f in (%SKIP_FILES%) do (
  git ls-files --error-unmatch "%%~f" >nul 2>&1
  if errorlevel 1 (
    echo skipped ^(not tracked or not found^): %%~f
  ) else (
    git update-index --skip-worktree "%%~f"
    echo skip-worktree set: %%~f
  )
)

echo Done.
echo Flagged files:
git ls-files -v | findstr /b "S" || echo (none)

endlocal