#!/usr/bin/env bash
# git.sh - applies my Git setup on a new machine / fresh clone.
# Usage: run it from Git Bash, from the root of the repository:  ./git.sh

set -e

# ---------------------------------------------------------------
# 1) Global settings (once per machine)
# ---------------------------------------------------------------
# Pager: quit automatically when the output fits on one screen
git config --global core.pager "less -FRX"

# ---------------------------------------------------------------
# 2) Per-clone settings (once per clone of the repository)
# ---------------------------------------------------------------
# Files that stay tracked in the remote, but whose local changes
# I don't want Git to see. Paths relative to the repo root.
SKIP_FILES=(
  "path/to/file1"
  "path/to/file2"
)

# Make sure we are inside a Git repository
git rev-parse --is-inside-work-tree > /dev/null

for file in "${SKIP_FILES[@]}"; do
  if git ls-files --error-unmatch "$file" > /dev/null 2>&1; then
    git update-index --skip-worktree "$file"
    echo "skip-worktree set: $file"
  else
    echo "skipped (not tracked or not found): $file"
  fi
done

echo "Done."
echo "Flagged files:"
git ls-files -v | grep '^S' || echo "(none)"